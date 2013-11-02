package br.com.caelum.agiletickets.integration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.caelum.agiletickets.models.Sessao;
import br.com.caelum.agiletickets.persistencia.JPAEspetaculoDao;

public class ReservaTest {

	private FirefoxDriver browser;

	@Before
	public void setUp()  throws Exception{
		browser = new FirefoxDriver();
	}
	
	@After
	public void tearDown() {
		browser.close();
	}
	
	@Test
	public void quandoUmEstudanteReservar2IngressosOPrecoDeveSer70PorcentoDoPrecoIntegral() throws Exception {
		Sessao sessao = new Sessao();
		browser.get("http://localhost:8080/sessao/20");
		
		WebElement form = browser.findElement(By.id("reservaSessao"));
		form.findElement(By.id("qtde")).sendKeys("2");
			
		form.submit();
		
		browser.findElement(By.id("message"));
	}
}
