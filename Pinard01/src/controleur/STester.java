package controleur;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cave.CaveRemote;
import vin.Vin;



/**
 * Servlet controleur
 */
@WebServlet("/tester")
public class STester extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private CaveRemote cave;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public STester() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Vin v1=new Vin();
		v1.setCodeProduit(new Integer(765439));
		v1.setDesignation("Les Hauts du Tertre 1999");
		v1.setRegion("Bordeaux (Margaux)");
		v1.setCouleur("rouge");
		v1.setPrix(11.50);
		v1.setRemise(0);
		v1.setQuantite(2);

		Vin v2=new Vin();
		v2.setCodeProduit(new Integer(543289));
		v2.setDesignation("Château Marquis de Terme 1998");
		v2.setRegion("Bordeaux (Margaux)");
		v2.setCouleur("rouge");
		v2.setPrix(19.00);
		v2.setRemise(0);
		v2.setQuantite(3);

		Vin v3=new Vin();
		v3.setCodeProduit(new Integer(782377));
		v3.setDesignation("Clos du Marquis 1999");
		v3.setRegion("Bordeaux (Saint-Julien)");
		v3.setCouleur("rouge");
		v3.setPrix(22.90);
		v3.setRemise(0);
		v3.setQuantite(15);

		Vin v4=new Vin();
		v4.setCodeProduit(new Integer(974534));
		v4.setDesignation("Clos du Baron 1998");
		v4.setRegion("Bordeaux (Saint-Julien)");
		v4.setCouleur("blanc");
		v4.setPrix(45.20);
		v4.setRemise(0);
		v4.setQuantite(54);


		System.out.println("ajout du produit v1 : "+v1);
		cave.ajoutVin(v1);

		System.out.println("ajout du produit v2 : "+v2);
		cave.ajoutVin(v2);

		System.out.println("ajout du produit v3 : "+v3);
		cave.ajoutVin(v3);
		v3.setQuantite(10);
		cave.updateVin(v3);

		System.out.println("ajout du produit v4 : "+v4);
		cave.ajoutVin(v4);

		cave.updateQuantite(v4.getCodeProduit(),50);
		cave.updateVin(v3);

		System.out.println("liste des vins enregistrés :");
		Collection<Vin> vins=cave.findAll();
		Iterator<Vin> it=vins.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}

		System.out.println("suppression du vin "+v3);
		cave.deleteVin(new Integer(782377));



		System.out.println("liste des vins enregistrés:");
		vins = cave.findAll();
		it=vins.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		
		// info
		String message="<h1>Regardez dans votre console et dans votre base de données MySQL <strong>pratique</strong></h1>";
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html><html>");
     	out.println("<head>");
     	out.println("<title>Pinard01</title>");
     	out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'><link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css' integrity='sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M' crossorigin='anonymous'>");
     	out.println("<script src='https://code.jquery.com/jquery-3.2.1.slim.min.js' integrity='sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN' crossorigin='anonymous'></script><script src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js' integrity='sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4' crossorigin='anonymous'></script>");
     	out.println("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js' integrity='sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1' crossorigin='anonymous'></script>");
     	out.println("</head>");
     	out.println("<body>");
     	out.println("<h1>"+message+"</h1>");
     	out.println("<p>");
       	out.println("<p>Vous êtes dans votre servlet Controleur !</p><br>");
     	out.println("</body>");
     	out.println("</html>");
     	out.close();
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{}

}
