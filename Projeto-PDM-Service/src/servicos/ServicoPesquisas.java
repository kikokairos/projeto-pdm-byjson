package servicos;

import java.util.ArrayList;
import java.util.List;

import modelo.Pesquisas;

public class ServicoPesquisas {
		
	public List <Pesquisas> getAll(){
		return PesquisasBD.getAll();
	}
	
	public Pesquisas getById(String id){
		return PesquisasBD.getById(id);
	}
	
	public static class PesquisasBD{
		private static List<Pesquisas> enquetes;
						
		static{
			enquetes = new ArrayList<Pesquisas>();
			enquetes.add(new Pesquisas("11","Em que você votará para presidente?", "2014-09-07",
					"Aércio", "Dilmá", "Marina", 0, 0, 0));
			enquetes.add(new Pesquisas("12","Em que você votará para governador?", "2014-09-08",
					"Cassacio", "Ricardo", "Major", 0, 0, 0));
			enquetes.add(new Pesquisas("13","Em que você votará para senador?", "2014-09-07",
					"Ari", "Fábio", "Diego", 0, 0, 0));
		}
		
		public static List<Pesquisas> getAll(){
			return enquetes;
		}
		
		public static Pesquisas getById(String id){
			for (Pesquisas pesq : enquetes) {
				if (pesq.getId().equals(id))
					return pesq;
			}
			return null;
		}
		
	}

}


