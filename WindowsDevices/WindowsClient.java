/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WindowsDevices;

import org.w3c.dom.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.*;
import java.io.*;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import com.src.MainSpace;
/**
 *
 * @author Shane
 */
public class WindowsClient {
    
    private String aDDom = null;
    private int userType = 0;
    
    public MainSpace mainWin;
    
    public void WindowsClient(String usage) throws IOException, ParserConfigurationException, SAXException{
        switch(usage){
            case "Kiosk":
                userType = 1;
                break;
            case "Local Multiuser":
                break;
            case "Domain Multiuser":
                String [] availDoms = findDomains();
                this.aDDom = (String)JOptionPane.showInputDialog(mainWin,
                        "Select the Domain this device will be a part of",
                        "ComboBox Dialog", JOptionPane.QUESTION_MESSAGE, null,availDoms,availDoms[0]);
                break;
        }
    }
    
    private String[] findDomains () throws IOException, ParserConfigurationException, SAXException{
        DocumentBuilderFactory domReadFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder domFileBuilder = domReadFactory.newDocumentBuilder();
        //Fetch Active Directory Database File
        Document domDoc = domFileBuilder.parse(new File("domains.xml"));
        domDoc.getDocumentElement().normalize();
        
        Element root = domDoc.getDocumentElement();
        NodeList domList = domDoc.getElementsByTagName("domain");
        String domainArr[] = null;
        
        for (int i =0; i < domList.getLength(); i++)
        {
            Node node = domList.item(i);
            if(node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element curDom = (Element) node;
                domainArr[i] = curDom.getAttribute("name");
            }
        }
        
        return domainArr;
    }
}
