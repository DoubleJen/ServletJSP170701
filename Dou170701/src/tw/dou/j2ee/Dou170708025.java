package tw.dou.j2ee;
//Draw DynamicImage
//025=>026

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
//
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Dou170708025")
public class Dou170708025 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("image/jpeg");//輸出image，其檔案為jpeg
		String rate = request.getParameter("rate");
		float floatRate =  Float.parseFloat(rate);//String=>Float
		
		BufferedImage bimg = new BufferedImage(400, 20, BufferedImage.TYPE_INT_BGR);
		Graphics2D g2d = bimg.createGraphics();
		
		g2d.setColor(Color.black);//底色
		g2d.fillRect(0, 0, 400, 20);
		g2d.setColor(Color.red);//底色再一層顏色
		g2d.fillRect(0, 0, (int)(400*floatRate/100), 20);
		
		//Output
		OutputStream out = response.getOutputStream();//binary用Input/OuputStream
													  //取得輸出物件
		ImageIO.write(bimg, "jpeg", out);
		out.flush();
		out.close();
		
	}

}
