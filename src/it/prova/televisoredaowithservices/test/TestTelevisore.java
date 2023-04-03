package it.prova.televisoredaowithservices.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import it.prova.televisoredaowithservices.model.Televisore;
import it.prova.televisoredaowithservices.service.MyServiceFactory;
import it.prova.televisoredaowithservices.service.televisore.TelevisoreService;

public class TestTelevisore {

	public static void main(String[] args) {
			
			TelevisoreService televisoreService = MyServiceFactory.getTelevisoreServiceImpl();
			
			try {
				
		//		System.out.println("in tabella ci sono " +televisoreService.listAll().size()+ " elementi.");
				
		//		testInserisciNuovo(televisoreService);
		//		System.out.println("in tabella ci sono " +televisoreService.listAll().size()+ " elementi.");
				
		//		testAggiorna(televisoreService);
		//		System.out.println("in tabella ci sono " +televisoreService.listAll().size()+ " elementi.");
				
		//		testRimuovi(televisoreService);
		//		System.out.println("in tabella ci sono " +televisoreService.listAll().size()+ " elementi.");
				
		//		testQualeEIlTelevisorePiuGrande(televisoreService);
		//		System.out.println("in tabella ci sono " +televisoreService.listAll().size()+ " elementi.");
				
		//		testQuantiTelevisoriSonoStatiProdottiInUnIntervalloDiDate(televisoreService);
		
		//		testCercaComeExample(televisoreService);
				
		//		testFindAllMarcheProdottiUltimiSeiMesi(televisoreService);
				
				testMarcheDegliUltimiSeiMesi(televisoreService);
				
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		} //chiusura main
		
		
		//CRUD
		
		private static void testInserisciNuovo (TelevisoreService televisoreService) throws Exception{
			System.out.println(".......testInserimentoNuovo inizio.............");
			Televisore newTelevisoreInstance = new Televisore("Panasonic", "p504k", 50, LocalDate.of(2021,12, 20));
			if (televisoreService.inserisciNuovo(newTelevisoreInstance) != 1)
				throw new RuntimeException("testInserimentoNuovoUser FAILED ");

			System.out.println(".......testInserimentoNuovo PASSED.............");
		}
		
		
		
		private static void testAggiorna (TelevisoreService televisoreService) throws Exception {
				System.out.println(".......testAggiorna inizio.............");
				
				List<Televisore> elencoTelevisori= televisoreService.listAll();
				if(elencoTelevisori.size()<1){
					throw new RuntimeException("errore: non sono presenti televisori sul DB");
				}

				if (televisoreService.inserisciNuovo(new Televisore("lg","lg1",70, LocalDate.of(2023, 01,01))) !=1) {
					throw new RuntimeException("testAggiorna: inserimento preliminare FAILED ");
				}

				String nuovoModello = "Hidense";
				Televisore toBeUpdated = elencoTelevisori.get(0);
				toBeUpdated.setModello(nuovoModello);
				if (televisoreService.aggiorna(toBeUpdated) != 1)
					throw new RuntimeException("testUpdateUser FAILED ");

				System.out.println(".......testUpdate PASSED.............");
		}
		
		
		private static void testRimuovi (TelevisoreService televisoreService) throws Exception {
			System.out.println(".......testRimuovi inizio.............");
			// recupero tutti gli user
			List<Televisore> interoContenutoTabella = televisoreService.listAll();
			if (interoContenutoTabella.isEmpty() || interoContenutoTabella.get(0) == null)
				throw new Exception("Non ho nulla da rimuovere");

			Long idDelPrimo = interoContenutoTabella.get(4).getId();
			if (televisoreService.rimuovi(idDelPrimo) != 1)
				throw new RuntimeException("testRimuovi FAILED ");

			System.out.println(".......testRimuovi PASSED.............");
			
		}
		
		private static void testQualeEIlTelevisorePiuGrande(TelevisoreService televisoreService) throws Exception{
			System.out.println(".........testQualeEIlTelevisorePiuGrande inizio..............");
			List<Televisore> interoContenutoTabella = televisoreService.listAll();
			if (interoContenutoTabella.isEmpty() || interoContenutoTabella.get(0) == null)
				throw new Exception("errore: non ci sono voci");
			Televisore televisorePiuGrande= televisoreService.qualeEIlTelevisorePiuGrande();
			System.out.println(televisorePiuGrande);
			System.out.println("........testQualeEIlTelevisorePiuGrande fine.........");
			
		}
			
		
		private static void testCercaComeExample (TelevisoreService televisoreService) throws Exception {
			System.out.println("......testCercaComeExample inizio.......");
			List<Televisore> elencoTelevisori= televisoreService.listAll();
			if (elencoTelevisori.size()<1) {
				throw new RuntimeException("errore: non sono presenti compagnie sul db");
			}
			Televisore televisoreExample= new Televisore("Samsung", "Hidense", 0, null);
			List<Televisore> elencoTelevisoriComeExample= televisoreService.cercaComeEsempio(televisoreExample);
			if (elencoTelevisoriComeExample.size()<1) {
				throw new RuntimeException("errore: non sono presenti voci nel db.");
			}
			System.out.println("gli elementi presenti sono "+elencoTelevisoriComeExample.size());
			System.out.println(elencoTelevisoriComeExample);
			System.out.println("......testCercaComeExample fine.......");
		
		}

		
		
		private static void testQuantiTelevisoriSonoStatiProdottiInUnIntervalloDiDate(TelevisoreService televisoreService) throws Exception{
			System.out.println(".........testQuantiTelevisoriSonoStatiProdottiInUnIntervalloDiDate inizio..............");
			List<Televisore> listaTelevisori = televisoreService.listAll();
			if (listaTelevisori.isEmpty() || listaTelevisori.get(0) == null)
				throw new Exception("errore: non ci sono voci");
			LocalDate dataInizio= LocalDate.parse("2022-01-01");
			LocalDate dataFine= LocalDate.parse("2023-12-30");
			int quantiTelevisoriTraData= televisoreService.quantiTelevisoriSonoStatiProdottiInUnIntervalloDiDate(dataInizio, dataFine);
			System.out.println(quantiTelevisoriTraData);
			System.out.println(".........testQuantiTelevisoriSonoStatiProdottiInUnIntervalloDiDate fine..............");

		}
		
		private static void testMarcheDegliUltimiSeiMesi(TelevisoreService televisoreService) throws Exception {
			System.out.println(".......testMarcheDegliUltimiSeiMesi inizio.............");
			
			List<String> result = new ArrayList<>();
			
			result=televisoreService.marcaTelevisoriProdottiNegliUltimiSeiMesi();
			System.out.println(result);

			System.out.println(".......testMarcheDegliUltimiSeiMesi fine.............");
		}
		
}

			
	
