package com.example.jsontoxml;

import org.json.JSONObject;
import org.json.XML;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JsonToXmlApplication {

	public static void main(String[] args) {
		SpringApplication.run(JsonToXmlApplication.class, args);

		//--------------------------------------
		// (1) monta "paises.xml" em uma string
		//--------------------------------------

		String xmlString = "<?xml version=\"1.0\"?>" +
				"<paises>" +
				"<pais sigla=\"BR\">" +
				"<nome>Brasil</nome>" +
				"<populacao>196655014</populacao>" +
				"</pais>" +
				"<pais sigla=\"AR\">" +
				"<nome>Argentina</nome>" +
				"<populacao>40764561</populacao>" +
				"</pais>" +
				"</paises>";

		//--------------------------------------------------------------
		// (2) cria um JSONObject a partir do arquivo XML
		//     com o uso do método estático "toJSONObject" da classe XML
		//---------------------------------------------------------------

		JSONObject paisesJson = XML.toJSONObject(xmlString);

		//--------------------------------------------------------------
		// (3) gera uma string JSON e imprime
		//---------------------------------------------------------------

		System.out.println(paisesJson.toString());

		//--------------------------------------------------------------
		// (4) gera um objeto JSON a partir de paisesJson.toString()
		//---------------------------------------------------------------

		JSONObject novoPaisesJSON = new JSONObject(paisesJson.toString());

		//--------------------------------------------------------------------------
		// (5) gera um texto XML a partir desse novo objeto e imprime o seu conteúdo
		//---------------------------------------------------------------------------

		String xmlStr2 = XML.toString(novoPaisesJSON);

		System.out.println(xmlStr2);

//		JSONObject json = new JSONObject("{\n" +
//				"    \"glossary\": {\n" +
//				"        \"title\": \"example glossary\",\n" +
//				"\t\t\"GlossDiv\": {\n" +
//				"            \"title\": \"S\",\n" +
//				"\t\t\t\"GlossList\": {\n" +
//				"                \"GlossEntry\": {\n" +
//				"                    \"ID\": \"SGML\",\n" +
//				"\t\t\t\t\t\"SortAs\": \"SGML\",\n" +
//				"\t\t\t\t\t\"GlossTerm\": \"Standard Generalized Markup Language\",\n" +
//				"\t\t\t\t\t\"Acronym\": \"SGML\",\n" +
//				"\t\t\t\t\t\"Abbrev\": \"ISO 8879:1986\",\n" +
//				"\t\t\t\t\t\"GlossDef\": {\n" +
//				"                        \"para\": \"A meta-markup language, used to create markup languages such as DocBook.\",\n" +
//				"\t\t\t\t\t\t\"GlossSeeAlso\": [\"GML\", \"XML\"]\n" +
//				"                    },\n" +
//				"\t\t\t\t\t\"GlossSee\": \"markup\"\n" +
//				"                }\n" +
//				"            }\n" +
//				"        }\n" +
//				"    }\n" +
//				"}");
//
//		System.out.println(json);
//		System.out.println();
//		String xml = XML.toString(json);
//		System.out.println(xml);

	}

}

