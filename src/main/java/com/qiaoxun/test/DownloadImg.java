package com.qiaoxun.test;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.*;

public class DownloadImg {

    /*
    不带cookie下载图片
     */
    public static void download(String url) throws IOException {
        Connection.Response response = Jsoup.connect(url).ignoreContentType(true).execute();
        byte[] img = response.bodyAsBytes();
        /*String[] paths=new String[Test.cartoons];
        for (int i=1;i<=Test.cartoons;i++){
            String path="/bookimages/100130/cover"+i+".jpg";
            paths[i]=path;

        }*/
        //System.out.println(img.length);
        savaImage(img, "D:\\javaCrawJWXT", "/bookimages/100130/cover1.jpg");
    }
    /*
    保存图片
     */
    public static void savaImage(byte[] img,String filePath,String fileName) {
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        File file = null;
        File dir = new File(filePath);
        try {
            //判断文件目录是否存在
            if(!dir.exists() && dir.isDirectory()){
                dir.mkdir();
            }
            file = new File(filePath+"\\"+fileName);
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            bos.write(img);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            if(bos!=null){
                try {
                    bos.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if(fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }



    }

    public static void main(String[] args) throws IOException {
        String []urls={"http://tu.027cgb.com/617983/漫画/暧昧女上司/第1话/10.jpg",
                "http://tu.027cgb.com/617983/漫画/暧昧女上司/第1话/14.jpg",
                "http://tu.027cgb.com/617983/漫画/暧昧女上司/第1话/18.jpg",
                "http://tu.027cgb.com/617983/漫画/暧昧女上司/第1话/2.jpg",
                "http://tu.027cgb.com/617983/漫画/暧昧女上司/第1话/24.jpg"};
        for (int i=0;i<urls.length;i++){
            download(urls[i]);
        }

    }
}
