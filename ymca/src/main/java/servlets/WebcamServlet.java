package servlets;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;

/**
 * Servlet implementation class WebcamServlet
 */
public class WebcamServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WebcamServlet()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response)
	        throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
	        throws ServletException, IOException
	{
			final String data = request.getParameter("webcamImage");
			//Decode image, for some reason decode() doesn't seem to handle '+'
			String decodedData = java.net.URLDecoder.decode(data, "UTF-8");
			decodedData = decodedData.replace(' ', '+');
			final byte[] imagedata = DatatypeConverter.parseBase64Binary(decodedData.substring(decodedData.indexOf(",") + 1));
			final BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(imagedata));
			
			//TODO use image
			ImageIO.write(bufferedImage, "png", new File("D:/img.png"));
	}

}
