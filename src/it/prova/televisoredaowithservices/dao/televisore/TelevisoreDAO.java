package it.prova.televisoredaowithservices.dao.televisore;

import java.time.LocalDate;
import java.util.List;

import it.prova.televisoredaowithservices.dao.IBaseDAO;
import it.prova.televisoredaowithservices.model.Televisore;

public interface TelevisoreDAO extends IBaseDAO<Televisore> {

	public Televisore whichTelevisionIsTheBiggest() throws Exception;

	public int howManyTelevisionsWereProducedBeetweenThisDate(LocalDate data1, LocalDate data2) throws Exception;

	public List<String> MarcaOfTelevisionsProducedInTheLastSixMonths() throws Exception;
}
