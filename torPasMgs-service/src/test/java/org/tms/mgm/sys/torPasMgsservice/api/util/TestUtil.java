package org.tms.mgm.sys.torPasMgsservice.api.util;

public interface TestUtil {
	String BASE_URL = "api/topas/mgm/v1";
	final String BASE_URL_EXTENSION = "/BV3078D";
	String UPDATE_POSITIVE = " {\r\n" + "        \"id\": 2,\r\n" + "        \"passNo\": \"updated\",\r\n"
			+ "        \"customerNo\": \"updated\",\r\n" + "        \"city\": {\r\n"
			+ "            \"customerCity\": \"dagenham\",\r\n" + "            \"passCity\": \"dagenham\"\r\n"
			+ "        },\r\n" + "        \"expiraryDate\": \"2020-03-01\",\r\n" + "        \"passActive\": \"YES\"\r\n"
			+ "    }";
	String FIND_BY_ID_RESULT = "{\"id\":2,\"passNo\":\"BV3078D\",\"customerNo\":\"CSG2DB\",\"city\":{\"customerCity\":\"BEDFORD\",\"passCity\":\"LONDON\"},\"expiraryDate\":\"2020-03-01\",\"passActive\":\"NO\"}";
	String FIND_ALL_RESULT = "[\r\n" + "    {\r\n" + "        \"id\": 1,\r\n" + "        \"passNo\": \"P3078D\",\r\n"
			+ "        \"customerNo\": \"CTR12D\",\r\n" + "        \"city\": {\r\n"
			+ "            \"customerCity\": \"LONDON\",\r\n" + "            \"passCity\": \"LONDON\"\r\n"
			+ "        },\r\n" + "        \"expiraryDate\": \"2020-03-01\",\r\n" + "        \"passActive\": \"YES\"\r\n"
			+ "    },\r\n" + "    {\r\n" + "        \"id\": 2,\r\n" + "        \"passNo\": \"BV3078D\",\r\n"
			+ "        \"customerNo\": \"CSG2DB\",\r\n" + "        \"city\": {\r\n"
			+ "            \"customerCity\": \"BEDFORD\",\r\n" + "            \"passCity\": \"LONDON\"\r\n"
			+ "        },\r\n" + "        \"expiraryDate\": \"2020-03-01\",\r\n" + "        \"passActive\": \"NO\"\r\n"
			+ "    },\r\n" + "    {\r\n" + "        \"id\": 3,\r\n" + "        \"passNo\": \"PR978D\",\r\n"
			+ "        \"customerNo\": \"CFR12D\",\r\n" + "        \"city\": {\r\n"
			+ "            \"customerCity\": \"LONDON\",\r\n" + "            \"passCity\": \"LONDON\"\r\n"
			+ "        },\r\n" + "        \"expiraryDate\": \"2020-03-01\",\r\n" + "        \"passActive\": \"NO\"\r\n"
			+ "    },\r\n" + "    {\r\n" + "        \"id\": 4,\r\n" + "        \"passNo\": \"RA278D\",\r\n"
			+ "        \"customerNo\": \"CP12DK\",\r\n" + "        \"city\": {\r\n"
			+ "            \"customerCity\": \"WATFORD\",\r\n" + "            \"passCity\": \"LONDON\"\r\n"
			+ "        },\r\n" + "        \"expiraryDate\": \"2020-03-01\",\r\n" + "        \"passActive\": \"YES\"\r\n"
			+ "    }\r\n" + "]";
}