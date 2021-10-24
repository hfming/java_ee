package com.hfm.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

/**
 * @author hfming2016@163.com
 * @version 1.01 2020-10-07 16:09
 * @Description 文件管理器
 * @date 2020/10/7
 */
@Controller(value = "fileController")
@RequestMapping(path = "/file")
public class FileController {
    private final String SUCCESS = "success";

    /**
     * 文件下载
     */
    @RequestMapping(path = "dowmload")
    public void fileDowmload(HttpServletRequest request, HttpServletResponse response) {
        try {
            System.out.println("文件下载 - 开始");
            String fileName = "[高清 1080P] 【ASMR】S. ASMR 格力高零食（咀嚼音）.flv";
            String realPath = request.getServletContext().getRealPath("/video/" + fileName);

            String ua = request.getHeader("User-Agent");
            // 判断是否是火狐浏览器
            if (ua.contains("Firefox")) {
                // 使用下面的格式进行 BASE64 编码后
                // Java 8的java.util套件中，新增了Base64的类别，可以用来处理Base64的编码与解码
                Base64.Encoder encoder = Base64.getEncoder();
                // 进行 Base64 编码
                String s = encoder.encodeToString(fileName.getBytes("utf-8"));
                // 拼串
                String str = "atachment; fileName=" + "=?utf-8?B" + s + "?=";
                // 设置到响应头中
                response.setHeader("Content-Dispositon", str);
            } else {
                // 把中文名进行 UTF-8 编码操作。中文名需要 URLEncode 编码
                String encodeName = URLEncoder.encode(fileName, "UTF-8");
                // 然后把编码后的字符串设置到响应头中
                // response设置下载文件名无效。因为response 参数设置要在out对象加入数据之前
                // 设置响应头 这个响应头告诉浏览器。这是需要下载的。
                // atachment 表示附件，也就是下载的一个文件。fileName=后面，表示下载的文件名。
                response.addHeader("Content-Disposition", "attachment;filename=" + encodeName);
            }

            // 获取文件类型
            String mimeType = request.getServletContext().getMimeType(realPath);

            // 设置文件输出类型
            response.setContentType(mimeType);

            // 获取 InputStream 文件输入流
            FileInputStream fileInputStream = new FileInputStream(realPath);

            // 获取浏览器输出流
            ServletOutputStream outputStream = response.getOutputStream();

            // 使用 IOIOUtils 工具类复制文件
            IOUtils.copy(fileInputStream, outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用ResponseEntity实现下载文件的功能
     * @param session
     * @return
     * @throws IOException
     */
    @RequestMapping("/testDown")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException {
        //获取ServletContext对象
        ServletContext servletContext = session.getServletContext();
        //获取服务器中文件的真实路径
        String realPath = servletContext.getRealPath("/static/img/1.jpg");
        //创建输入流
        InputStream is = new FileInputStream(realPath);
        //创建字节数组
        byte[] bytes = new byte[is.available()];
        //将流读到字节数组中
        is.read(bytes);
        //创建HttpHeaders对象设置响应头信息
        MultiValueMap<String, String> headers = new HttpHeaders();
        //设置要下载方式以及下载文件的名字
        headers.add("Content-Disposition", "attachment;filename=1.jpg");
        //设置响应状态码
        HttpStatus statusCode = HttpStatus.OK;
        //创建ResponseEntity对象
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers, statusCode);
        //关闭输入流
        is.close();
        return responseEntity;
    }

    /**
     * 文件上传
     */
    @RequestMapping(path = "upload")
    public String fileUpload(HttpServletRequest request) {
        try {
            // 先获取到要上传的文件目录
            String path = request.getSession().getServletContext().getRealPath("/uploads");
            // 创建File对象，一会向该路径下上传文件
            File file = new File(path);
            // 判断路径是否存在，如果不存在，创建该路径
            if (!file.exists()) {
                file.mkdirs();
            }
            // 创建磁盘文件项工厂
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload fileUpload = new ServletFileUpload(factory);

            // 解析request对象,获取文件项
            List<FileItem> list = fileUpload.parseRequest(request);
            // 遍历
            for (FileItem fileItem : list) {
                // 判断文件项是普通字段，还是上传的文件
                if (fileItem.isFormField()) {
                    // 普通文件项
                } else {
                    // 上传文件项
                    // 获取到上传文件的名称
                    String filename = fileItem.getName();
                    System.out.println(filename);

                    // 可以将文件名设置成唯一的
                    // 上传文件
                    fileItem.write(new File(file, filename));
                    // 删除临时文件
                    fileItem.delete();
                }
            }
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * SpringMVC方式的文件上传
     * MultipartFile 文件解析器，需要在 Spring 核心配置文件中配置
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "upload2")
    public String fileupload2(HttpServletRequest request, MultipartFile upload) {
        try {
            // 先获取到要上传的文件目录
            String path = request.getSession().getServletContext().getRealPath("/uploads");
            // 创建File对象，一会向该路径下上传文件
            File file = new File(path);
            // 判断路径是否存在，如果不存在，创建该路径
            if (!file.exists()) {
                file.mkdirs();
            }

            // 从文件解析器中获取到上传文件的名称
            String filename = upload.getOriginalFilename();
            String uuid = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
            // 把文件的名称唯一化
            filename = uuid + "_" + filename;
            // 上传文件
            upload.transferTo(new File(file, filename));
            return SUCCESS;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 跨服务器上传文件
     *
     * @param upload
     * @return
     */
    @RequestMapping(value = "upload3")
    public String fileupload3(String picname, MultipartFile upload) {
        try {
            // 另外一个服务器的地址，文件传输的是否要确保目标服务器存在文件夹
            String FILESERVERURL = "http://localhost:9090/day06_spring_image/uploads/";

            //定义文件名
            String fileName = "";
            //1.获取原始文件名
            String uploadFileName = upload.getOriginalFilename();
            //2.截取文件扩展名
            String extendName = uploadFileName.substring(uploadFileName.lastIndexOf(".") + 1, uploadFileName.length());
            //3.把文件加上随机数，防止文件重复
            String uuid = UUID.randomUUID().toString().replace("-", "").toUpperCase();
            //4.判断是否输入了文件名
            if (!StringUtils.isEmpty(picname)) {
                fileName = uuid + "_" + picname + "." + extendName;
            } else {
                fileName = uuid + "_" + uploadFileName;
            }

            //5.创建sun公司提供的jersey包中的Client对象
            Client client = Client.create();
            //6.指定上传文件的地址，该地址是web路径
            WebResource resource = client.resource(FILESERVERURL + fileName);
            //7.实现上传
            resource.put(upload.getBytes());
            return SUCCESS;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
