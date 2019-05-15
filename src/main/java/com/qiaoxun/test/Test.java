package com.qiaoxun.test;


import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Test {
    private static Map<String, String> cookies = null;
    private static Document document=null;
    public static int cartoons=0;

    /**
     * 模拟登录获取cookie和sessionid
     */
    public static void login() throws IOException {
        String urlLogin = "http://www.yymh8.com/index.php?m=&c=MhPublic&a=binding";
        Connection connect = Jsoup.connect(urlLogin);
        // 伪造请求头
        connect.header("Accept", "application/json, text/javascript, */*; q=0.01").header("Accept-Encoding",
                "gzip, deflate");
        connect.header("Accept-Language", "zh-CN,zh;q=0.8").header("Connection", "keep-alive");
        connect.header("Content-Length", "68").header("Content-Type",
                "application/x-www-form-urlencoded; charset=UTF-8");
        connect.header("Host", "www.yymh8.com").header("Referer", "http://www.yymh8.com/index.php?m=&c=MhPublic&a=binding&fr=aHR0cDovL3d3dy55eW1oOC5jb20vaW5kZXgucGhwP209JmM9TWgmYT1ib29rX2NhdGU%3D");
        connect.header("User-Agent",
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36")
                .header("X-Requested-With", "XMLHttpRequest");

        // 携带登陆信息
        // mobile:pkran1986
        //pass:7788120K
        //fr:index.php?m=&c=Mh&a=my
        connect.data("mobile", "pkran1986").data("pass", "7788120K").data("fr", "index.php?m=&c=Mh&a=my");

        //请求url获取响应信息
        Connection.Response res = connect.ignoreContentType(true).method(Connection.Method.POST).execute();// 执行请求
        // 获取返回的cookie
        cookies = res.cookies();
    }

    /**
     * 获取漫画名称和url
     */
    public static void parse() throws IOException {
        String initUrl = "http://www.yymh8.com/index.php?m=&c=Mh&a=book_cate&p_reload=1&reload_time=1557799064903";
        // 直接获取DOM树，带着cookies去获取
        document = Jsoup.connect(initUrl).cookies(cookies).post();
        String init="http://www.yymh8.com";
        //选择器定位
        Elements elements = document.select("#html_box").select(".item");
        cartoons=elements.size();
        //获取内部元素（目标数据）
        for (Element element : elements) {
            //获取封面图片地址
            String image=element.select("#html_box > div:nth-child(1) > a > div.cover > img").attr("src").trim();
            //下载封面图片
            //DownloadImg.download(image);
            //获取漫画url
            String url = init+element.select("a").attr("href").trim();
            //带着漫画url再次发请求，进入漫画内部页
            document = Jsoup.connect(url).cookies(cookies).get();
            //System.out.println(document);
            //开始获取目标数据

            //名称
            String title=document.select("body > div.cover-box > div.container > div.title").text();
            //横着的封面图地址
            String cover=document.select("body > div.cover-box > div.bg > img").attr("src").trim();
            //下载横着的封面图
            //DownloadImg.download(cover);
            //描述
            String desc=document.select("#book-info > article > div.body").text();
            //作者
            String author=document.select("#book-info > article > div.author").text();
            author.substring(3);
            //标签
            String keyWord=document.select("body > div.cover-box > div.container > div.tags").text();
            //浏览量
            String view=document.select("#book-info > div > div:nth-child(1)").text();
            //view.substring()
            //订阅量
            String mark=document.select("#book-info > div > div:nth-child(3)").text();
            //最新章节
            String lastChapterTitle=document.select("#chapters > div.ch > div > span").text();
            //获取第一章节的url,然后更换这个url的最后一个参数，一直到这个漫画的最新章节数
            String chapterUrl=document.select("#html_box > div:nth-child(1) > a").attr("href").trim();
            //截取该漫画最新一期编号
            String chapter=init+chapterUrl.substring(0,chapterUrl.length()-1);
            /*System.out.println(chapter);*/
            //对编号类型转换
            int chapters=Integer.parseInt(lastChapterTitle.substring(3,lastChapterTitle.length()-1));
            /*System.out.println(chapters);*/
            //拿到新的url,再次发起请求
            /*for (int q=1;q<=chapters;q++){
                String newUrl=chapter+q;
                document = Jsoup.connect(newUrl).cookies(cookies).get();
                //System.out.println(document);
                //拿到图片地址，进行下载
                Elements elements2=document.select(".read-article").select("item");
                for (Element element2:elements2){
                    String imgUrl=element2.select("img").attr("src").trim();
                    System.out.println("开始下载图片了！！！");
                    //下载每个章节里的图片
                    DownloadImg.download(imgUrl);
                }
            }*/
            System.out.println(cover+"\n"+title+"\n"+desc.substring(0,desc.length()-10)+"\n"+author.substring(3)+"\n"+keyWord+"\n"+view.substring(4)+"\n"+mark.substring(0, mark.indexOf("人"))+"\n"+lastChapterTitle.substring(3,lastChapterTitle.length()-1));
        }
    }

    public static void main(String[] args) throws IOException {

        // 先模拟登录获取到cookie和sessionid并存到全局变量cookies中
        login();
        //从document中解析出目标数据
        parse();

    }



}
