package handler;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import entities.*;

/**
 * Created by qtt on 6/8/2015.
 */
public class AssetsManager {
    // Đối tượng quản lý thư mục asset trong một ứng dụng Android
    AssetManager assetManager;
    ArrayList<Player> playerList;
    ArrayList<Location> locationList;
    //


    public AssetsManager(Context mainActivity)
    {
        assetManager = mainActivity.getAssets();
        parsePlayerXML(new PlayerXMLHandler(),"player.xml");
        parseLocationXML(new LocationXMLHandler(),"location.xml");
    }

    private void parsePlayerXML(PlayerXMLHandler typeHandler, String filePathXML)
    {
        try {
            //Lấy 1 tập tin làm dữ liệu đầu vào
            InputStream is = assetManager.open(filePathXML);
            //Tạo đối tượng dùng cho việc phân tích cú pháp  tài liệu XML
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser();
            //Đối tượng đọc XML
            XMLReader xr = sp.getXMLReader();

            //Thiết lập nội dung xử lý
            xr.setContentHandler(typeHandler);
            //Nguồn dữ liệu vào
            InputSource inStream = new InputSource(is);
            //Bắt đầu xử lý dữ liệu vào
            xr.parse(inStream);
            playerList = typeHandler.getPlayerList();
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void parseLocationXML(LocationXMLHandler typeHandler, String filePathXML)
    {
        try {
            //Lấy 1 tập tin làm dữ liệu đầu vào
            InputStream is = assetManager.open(filePathXML);
            //Tạo đối tượng dùng cho việc phân tích cú pháp  tài liệu XML
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser();
            //Đối tượng đọc XML
            XMLReader xr = sp.getXMLReader();

            //Thiết lập nội dung xử lý
            xr.setContentHandler(typeHandler);
            //Nguồn dữ liệu vào
            InputSource inStream = new InputSource(is);
            //Bắt đầu xử lý dữ liệu vào
            xr.parse(inStream);
            locationList = typeHandler.getLocationList();
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
