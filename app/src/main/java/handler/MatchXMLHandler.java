package handler;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

import entities.*;

/**
 * Created by qtt on 6/7/2015.
 */
public class MatchXMLHandler extends DefaultHandler {
    boolean currentElement = false;
    String currentValue = "";

    String nameStats;
    Integer i1;
    Integer i2;
    boolean percent;

    private Match tempMatch;
    private ArrayList<Match> matchList;

    public ArrayList<Match> getMatchList()
    {
        return matchList;
    }

    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {

        currentElement = true;

        if (qName.equals("MatchList"))
        {
            matchList = new ArrayList<Match>();
        }
        else if (qName.equals("Match"))
        {
            tempMatch = new Match();
        }
    }

    public void endElement(String uri, String localName, String qName)
            throws SAXException {

        currentElement = false;

        if (qName.equalsIgnoreCase("NameStats"))
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
            tempMatch.getMatchStats().addStats(nameStats,i1,i2,percent);
        else if (qName.equalsIgnoreCase("NumSet"))
            tempMatch.getBoardInfo().numSet = Integer.valueOf(currentValue.trim());
        else if (qName.equalsIgnoreCase("Player1"))
            tempMatch.getBoardInfo().Player1 = currentValue.trim();
        else if (qName.equalsIgnoreCase("Player2"))
            tempMatch.getBoardInfo().Player2 = currentValue.trim();
        else if (qName.equalsIgnoreCase("Score1"))
            tempMatch.getBoardInfo().player1_score.add(currentValue.trim());
        else if (qName.equalsIgnoreCase("Score2"))
            tempMatch.getBoardInfo().player2_score.add(currentValue.trim());
        else if (qName.equalsIgnoreCase("Match"))
            matchList.add(tempMatch);

        currentValue = "";
    }

    public void characters(char[] ch, int start, int length)
            throws SAXException {

        if (currentElement) {
            currentValue = currentValue + new String(ch, start, length);
        }
    }
}
