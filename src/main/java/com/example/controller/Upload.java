package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.example.entity.Project;
import com.example.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

@RestController

public class Upload
{
    @Autowired
    private UserService userService;
    Map<String,Object> map=new HashMap<>();
    @PostMapping("/upload")
    @ResponseBody
    public String imageUpload(String name, String tel, String content,String title,String image)
    {
        if(Login.user==null)
        {
            map.put("code","404");
            map.put("msg","你还没有登录！！");
            return JSON.toJSONString(map);
        }
//        //获取文件名
//        String fileName = fileUpload.getOriginalFilename();
//        //文件目标位置
//        String tempFilePath = "C://Users//RUGAN//Desktop//mewjava//第四轮考核//MoneyProject//Image";
//        File temp = new File(tempFilePath);
//        //如果文件夹不存在就创建
//        if(!temp.exists())
//        {
//            temp.mkdir();
//        }
//        String resourcesPath = tempFilePath + "//" + fileName;
//
//        File upFile = new File(resourcesPath);
        //            fileUpload.transferTo(upFile);
        Project project = new Project(Login.user.getUsername(),name,tel,image,content,title);
        userService.uploadProject(project);
        map.put("code",200);
        map.put("msg","项目材料上传成功");
        map.put("result",project);
        return JSON.toJSONString(map);
    }

//    //展示图片
//    @PostMapping("/showImage")
//    public String imageLook (HttpServletResponse response,String fileURL) {
//
//        //"C://Users//RUGAN//Desktop//mewjava//第四轮考核//MoneyProject//Image//222200314吴荣榜.jpg"
//        File file = new File(fileURL);
//        byte[] bytes = new byte[1024];
//        try (OutputStream os = response.getOutputStream();
//             FileInputStream fis = new FileInputStream(file)){
//            while ((fis.read(bytes)) != -1) {
//                os.write(bytes);
//                os.flush();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return "success";
//    }
}
