package br.com.avmartins.controller;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.avmartins.exception.PopulaException;
import br.com.avmartins.exception.RankingException;

/**
 *
 * @author avmartins
 */
public class CorridaTest {
    
	public CorridaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Teste do método Popula da classe CorridaController.
     * @throws PopulaException 
     */
    @Test
    public void testPopula() throws PopulaException {
    	Corrida.getInstance().populaCorrida();
    }
    
    /**
     * Teste do método Ranking da classe CorridaController Com resultado da corrida.
     * @throws PopulaException 
     * @throws RankingException 
     */
    @Test
    public void testRanking() throws RankingException, PopulaException {
    	Corrida.getInstance().ranking(Corrida.getInstance().populaCorrida());
    }

    
}

