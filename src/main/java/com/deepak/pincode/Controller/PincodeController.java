package com.deepak.pincode.Controller;

import com.deepak.pincode.Serialize.SerializeTrie;
import com.deepak.pincode.Trie.TrieClass;
import com.deepak.pincode.Trie.TrieNode;
import com.deepak.pincode.entities.Pincode;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@WebServlet(
urlPatterns = {"/findpincode"},
        name = "firstservlet",
        loadOnStartup = 1,
        asyncSupported = false
)
public class PincodeController extends HttpServlet {
    private TrieNode root;

    private String fileName = "triePincode.txt";

    private TrieClass trieClass;

    @Override
    public void init(){
        System.out.println("inside init of servlet: deserialization of trie started");
        this.root = DeserializeToTrie();
        if(root == null)System.out.println("log: root in null");
        this.trieClass = new TrieClass(this.root);
        System.out.println("log: trie deserialization ended inside init method");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String cityName  = request.getParameter("city");

        List<Pincode> output = this.trieClass.searchByCity(cityName);

        out.println("<html><body>");
        out.println("<form action=\"findpincode\" method=\"GET\">");
        out.println("CityName: <input type=\"text\" name=\"city\"/>");
        out.println("<br><br/>");
        out.println("<input type=\"submit\" value=\"Search\"/>");
        out.println("</form>");
        out.println("<br>");
        out.println("<br>");
        out.println("<h2>pincode for: " +cityName +"</h2>");
        for (Pincode pincode: output){
            out.println(pincode.getPincode() +" "+ pincode.getOffice()+" "+pincode.getDistrict()+" "+pincode.getState());
            out.println("<br>");
        }
        out.println("</body></html>");
    }

    public TrieNode DeserializeToTrie(){
        System.out.println("Deserialization of trie Stated");

        TrieNode rootOut = null;

        try{
//            FileInputStream file = new FileInputStream(this.fileName);
            FileInputStream file = new FileInputStream(new File(getServletContext().getRealPath(this.fileName)));
//            FileInputStream file = getServletContext().getResourceAsStream(this.fileName);
            ObjectInputStream ob = new ObjectInputStream(file);

            rootOut = (TrieNode) ob.readObject();

            if (rootOut != null)
                System.out.println("Deserialization of trie ended");

        }
        catch (Exception e){
            e.printStackTrace();
        }

        return  rootOut;
    }
}
