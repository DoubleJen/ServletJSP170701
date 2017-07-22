package tw.dou.j2ee;
//jpeg寫字&輸出

import java.awt.Color;
import java.awt.Font;
//
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.prism.Image;

@WebServlet("/Dou170708027")
public class Dou170708027 extends HttpServlet {
		protected void doGet(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
			response.setContentType("image/jpeg");
			
			String imgPath = getServletContext().getInitParameter("upload-path");
			File imgFile = new File(imgPath, "Koala.jpg");
			
			BufferedImage bimg = ImageIO.read(imgFile);
			Graphics2D g2d = bimg.createGraphics();
			
			//做畫
			Font font = new Font(null, Font.BOLD+Font.ITALIC, 48);
			//變型
			AffineTransform tran = new AffineTransform();
			tran.rotate(Math.toRadians(45), 100, 0);//Math.toRadians(angdeg)轉徑度
											        //順時針:正 逆時針:負
			Font newfont = font.deriveFont(tran);
			
			g2d.setFont(newfont);
			g2d.setColor(Color.YELLOW);
			g2d.drawString("Hello資策會", 100, 100);
			
			
			//Output
			File outFile = new File(imgPath, "double.jpg");
			OutputStream out = response.getOutputStream();
			ImageIO.write(bimg, "jpg", out);//輸出螢幕
			ImageIO.write(bimg, "jpg", outFile);//輸出檔案
			out.flush();
			out.close();
			
			
			
	}

	
}
