package handler;

import com.example.hatde.tennisrecord.TennisStatistic;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import entities.Player;

/**
 * Created by qtt on 6/7/2015.
 */
public class PlayerXMLHandler extends DefaultHandler{

    boolean currentElement = false;
    String currentValue = "";

    String nameStats;
    Integer i1;
    Integer i2;
    boolean percent;

    private Player tempPlayer;
    private ArrayList<Player> playerList;

    public ArrayList<Player> getPlayerList()
    {
        return playerList;
    }

    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {

        currentElement = true;

        if (qName.equals("PlayerList"))
        {
            playerList = new ArrayList<Player>();
        }
        else if (qName.equals("Player"))
        {
            tempPlayer = new Player();
        }
    }

    public void endElement(String uri, String localName, String qName)
            throws SAXException {

        currentElement = false;

        if (qName.equalsIgnoreCase("NamePlayer"))
            tempPlayer.setName(currentValue.trim());
        else if (qName.equalsIgnoreCase("NameStats"))
            nameStats = currentValue.trim();
        else if (qName.equalsIgnoreCase("i1"))
            i1 = Integer.valueOf(currentValue.trim());
        else if (qName.equalsIgnoreCase("i2"))
            i2 = Integer.valueOf(currentValue.trim());
        else if(qName.equalsIgnoreCase("percent"))
        {
            if(currentValue.trim().matches("true")) percent=true;
            else percent = false;
        }
        else if (qName.equalsIgnoreCase("Statistic"))
            tempPlayer.getPlayerStats().addStats(nameStats,i1,i2,percent);
        else if (qName.equalsIgnoreCase("Player"))
            playerList.add(tempPlayer);

        currentValue = "";
    }

    public void characters(char[] ch, int start, int length)
            throws SAXException {

        if (currentElement) {
            currentValue = currentValue + new String(ch, start, length);
        }
    }
}
