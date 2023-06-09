package it.prova.televisoredaowithservices.service.televisore;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import it.prova.televisoredaowithservices.connection.MyConnection;
import it.prova.televisoredaowithservices.dao.Constants;
import it.prova.televisoredaowithservices.dao.televisore.TelevisoreDAO;
import it.prova.televisoredaowithservices.model.Televisore;

public class TelevisoreServiceImpl implements TelevisoreService {

	private TelevisoreDAO televisoreDao;

	public void setTelevisoreDao(TelevisoreDAO televisoreDao) {
		this.televisoreDao = televisoreDao;

	}

	public List<Televisore> listAll() throws Exception {

		List<Televisore> result = new ArrayList<>();

		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			televisoreDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = televisoreDao.list();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	public Televisore findById(Long idInput) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public int aggiorna(Televisore input) throws Exception {
		if (input == null || input.getId() == null || input.getId() < 1)
			throw new Exception("Valore di input non ammesso.");

		int result = 0;
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			televisoreDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = televisoreDao.update(input);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	public int inserisciNuovo(Televisore input) throws Exception {
		if (input == null)
			throw new Exception("Valore di input non ammesso.");

		int result = 0;
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			televisoreDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = televisoreDao.insert(input);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	public int rimuovi(Long input) throws Exception {
		if (input == null)
			throw new Exception("Valore di input non ammesso.");

		int result = 0;
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			televisoreDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = televisoreDao.delete(input);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	public Televisore qualeEIlTelevisorePiuGrande() throws Exception {

		Televisore result = new Televisore();
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			televisoreDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = televisoreDao.whichTelevisionIsTheBiggest();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	public int quantiTelevisoriSonoStatiProdottiInUnIntervalloDiDate(LocalDate data1, LocalDate data2)
			throws Exception {

		if (data1 == null || data2 == null) {
			throw new Exception("Valore non ammesso.");
		}
		int result = 0;
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			televisoreDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = televisoreDao.howManyTelevisionsWereProducedBeetweenThisDate(data1, data2);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;

	}

	public List<Televisore> cercaComeEsempio(Televisore input) throws Exception {
		if (input == null)
			throw new Exception("Valore di input non ammesso.");

		List<Televisore> result = new ArrayList<Televisore>();
		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			televisoreDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = televisoreDao.findByExample(input);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	public List marcaTelevisoriProdottiNegliUltimiSeiMesi() throws Exception {

		List<String> result = new ArrayList<>();

		try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {

			// inietto la connection nel dao
			televisoreDao.setConnection(connection);

			// eseguo quello che realmente devo fare
			result = televisoreDao.MarcaOfTelevisionsProducedInTheLastSixMonths();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
