package handler;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

import entities.Location;

/**
 * Created by qtt on 6/7/2015.
 */
public class LocationXMLHandler extends DefaultHandler {

    boolean currentElement = false;
    String currentValue = "";

    private Location tempLocation;
    private ArrayList<Location> locationList;

    public ArrayList<Location> getLocationList()
    {
        return locationList;
    }

    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {

        currentElement = true;

        if (qName.equals("LocationList"))
        {
            locationList = new ArrayList<Location>();
        }
        else if (qName.equals("Location"))
        {
            tempLocation = new Location();
        }
    }

    public void endElement(String uri, String localName, String qName)
            throws SAXException {

        currentElement = false;

        if (qName.equalsIgnoreCase("Name"))
            tempLocation.setName(currentValue.trim());
        else if (qName.equalsIgnoreCase("Longitude"))
            tempLocation.setLongitude(currentValue.trim());
        else if (qName.equalsIgnoreCase("Latitude"))
            tempLocation.setLatitude(currentValue.trim());
        else if (qName.equalsIgnoreCase("Location"))
            locationList.add(tempLocation);

        currentValue = "";
    }

    public void characters(char[] ch, int start, int length)
            throws SAXException {

        if (currentElement) {
            currentValue = currentValue + new String(ch, start, length);
        }
    }

}
