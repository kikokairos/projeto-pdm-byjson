package recursos;

import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import modelo.Pesquisas;

import org.jboss.resteasy.annotations.providers.jaxb.Wrapped;

import servicos.ServicoPesquisas;

@Path("bocadeurna")
public class RecursoPesquisas {
	
	private ServicoPesquisas servicoPesquisas;
	
	public RecursoPesquisas(){
		servicoPesquisas = new ServicoPesquisas();
	}
	
	@GET
	//2
	@Wrapped(element = "enquetePesquisas")
	//3
	@Produces({MediaType.APPLICATION_JSON })
	public List<Pesquisas> getAll() {
		return servicoPesquisas.getAll();
	}

	//4
	@Path("/{id: [0-9][0-9]}")
	@GET
	@Produces({MediaType.APPLICATION_JSON })
	public Pesquisas getById(@PathParam("id") String id) {
		Pesquisas res = servicoPesquisas.getById(id);
		//5
		if (res == null)
			throw new WebApplicationException(Status.NOT_FOUND);
		return res;
	}

	@Path("/{id: [0-9][0-9]}")
	@GET
	//6
	@Produces({ MediaType.TEXT_HTML })
	public String buscaPorIdHTML(@PathParam("id") String id,
			@QueryParam("cor") @DefaultValue("red") String cor,
			//7
			@QueryParam("tamanho") @DefaultValue("10") int tamanho) {
		Pesquisas res = servicoPesquisas.getById(id);
		if (res == null)
			throw new WebApplicationException(Status.NOT_FOUND);
		StringBuffer sb = new StringBuffer();
		sb.append("<span style='");
		sb.append("color:" + cor + ";");
		sb.append("font-size:" + tamanho + "px;");
		sb.append("'>");
		sb.append(res.getEnquete()+" "+res.getOp1()+" "+res.getOp2()+" "+res.getOp3());
		sb.append("</strong>");
		return sb.toString();
	}
	
	

}
