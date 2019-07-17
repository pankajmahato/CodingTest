package com.mindtree.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.binary.Base32;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.profesorfalken.jpowershell.PowerShell;
import com.profesorfalken.jpowershell.PowerShellNotAvailableException;
import com.profesorfalken.jpowershell.PowerShellResponse;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class Test {
	public static ObjectMapper mapper = new ObjectMapper();
	static {
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
	}


	static StringWriter sw = new StringWriter();
	static PrintWriter pw = new PrintWriter(sw);
	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(Test.class);





	public static void main(String args[]) throws Exception {

		//		removeExtraChar();
		//		dateFormat();
		//		jackson();
		//		splitRoles();
		//		loggerUtil();
		//		createDynamicForm();
		//		addHttp();
		//		getBasePath();
		//		checkException();
		//		deleteAllServiceEndpoints();
		//		testPatch();
		//		testString();
		//		getOctopusLogs();
		//		checkLong();
		//		checkSet();
		//		testUrl();
		//		humanReadableTime(3601000L);
		//		urlencode();
		//		splitMulti();
		//		jacksontest();
		//		testReplace();
		//		checkClass();
		//		base32();
		//		findInStringArray();
		//		characterDifference();
		//		traverseJson();
		//		fetchColumns();
		//		mergeList();
		//		compareString();
		//		checkForNumber();
		//		System.out.println(executeLocalCommand(command, task, logging, logger));
		//		generateUUID();
		//		replaceKey();
		//		executePowershell();
		//		executePowershell1();
		//		encodeURL();
		//		loggerCheck();
		//		addQuotes();
		//		endsWith();
		test();
	}





	private static void test() {
		String date = "2018-02-23T05:32:20.770Z";
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		df.setTimeZone(TimeZone.getTimeZone("GMT"));
		try {
			System.out.println(df.parseObject(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}





	private static void endsWith() {
		String str = "abhbvd.war";
		System.out.println(str.endsWith(""));

	}





	private static void addQuotes() throws Exception {
		String data = "In Progress,To Do";
		String poListString = "po1,po2,po3";
		String result = poListString.replaceAll("^|$", "\"").replaceAll(",", "\",\"");
		//
		//		URL url = new URL(result);
		//		URI uri = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url
		//				.getQuery(), url.getRef());

		//		System.out.println(uri.toASCIIString());

		//		String result = data.replaceAll("(,+)", "\"$1\"");
		System.out.println(result.replaceAll("\"", "\\\\\""));

	}





	private static void loggerCheck() {
		LOGGER.info("hi this is " + "first" + " and this is " + "second" + " and " + "third");
		LOGGER.info("hi this is {} and this is {} and {}", "first", "second", "third");
	}





	private static void encodeURL() throws Exception {
		String original = "http://jira/rest/api/2/search?jql=project = \'Member Centre\' and created >=\'2017/12/08 21:02\' &maxResults=50&startAt=0";
		String query = "?jql=project = \'Member Centre\' and created >=\'2017/12/08 21:02\' &maxResults=50&startAt=0";
		String working = "http://jira/rest/api/2/search?jql=project%20=%20%27Member%20Centre%27%20and%20created%20%3E=%272017/12/08%2021:02%27%20&maxResults=50&startAt=0";

		URL url = new URL(original);
		URI uri = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url
				.getQuery(), url.getRef());

		System.out.println(uri.toASCIIString());
		System.out.println(uri.toString());

	}





	private static void executePowershell1() throws IOException {
		//String command = "powershell.exe  your command";
		//Getting the version
		String command = "powershell.exe  $PSVersionTable.PSVersion";
		// Executing the command
		Process powerShellProcess = Runtime.getRuntime().exec(command);
		// Getting the results
		powerShellProcess.getOutputStream().close();
		String line;
		System.out.println("Standard Output:");
		BufferedReader stdout = new BufferedReader(new InputStreamReader(powerShellProcess.getInputStream()));
		while ((line = stdout.readLine()) != null) {
			System.out.println(line);
		}
		stdout.close();
		System.out.println("Standard Error:");
		BufferedReader stderr = new BufferedReader(new InputStreamReader(powerShellProcess.getErrorStream()));
		while ((line = stderr.readLine()) != null) {
			System.out.println(line);
		}
		stderr.close();
		System.out.println("Done");
	}





	private static void executePowershell() {
		//		//Execute a command in PowerShell session
		//		PowerShellResponse response1 = PowerShell.executeSingleCommand("D:\\Test.ps1");
		//
		//		//Print results
		//		System.out.println("List Processes:" + response1.getCommandOutput());
		//		System.out.println("List Processes:" + response1.isError() + " :::: " + response1.isTimeout());

		PowerShellResponse response = null;
		PowerShell powerShell = null;
		try {
			//Creates PowerShell session
			powerShell = PowerShell.openSession();
			//Increase timeout to give enough time to the script to finish
			Map<String, String> config = new HashMap<>();
			config.put("maxWait", "10000");

			//Execute script
			response = powerShell.configuration(config).executeScript("D:\\Test.ps1");

			//Print results if the script
			System.out.println("Script output:" + response.getCommandOutput());
			System.out.println("List Processes:" + response.isError() + " :::: " + response.isTimeout());
		} catch (PowerShellNotAvailableException ex) {
			//Handle error when PowerShell is not available in the system
			//Maybe try in another way?
		} finally {
			//Always close PowerShell session to free resources.
			if (powerShell != null) {
				powerShell.close();
			}
		}
	}





	private static void replaceKey() {
		String vars = "host_name=Demo repo_name=liferaydeploy group_id=com.mindtree.lifray";
		String temp = StringUtils.substring(vars, StringUtils.indexOf(vars, "host_name") + "host_name".length() + 1);
		String result = StringUtils.replace(vars, StringUtils.substring(temp, 0, StringUtils.indexOf(temp, " ") == -1 ?
				temp.length() : StringUtils.indexOf(temp, " ")), "replaced");
		System.out.println(result);
		System.out.println(replaceValue(vars, "repo_name", "done"));
	}





	private static String replaceValue(String seq, String searchSeq, String replaceSeq) {
		String temp = StringUtils.substring(seq, StringUtils.indexOf(seq, searchSeq) + searchSeq.length() + 1);
		return StringUtils.replace(seq, StringUtils.substring(temp, 0, StringUtils.indexOf(temp, " ")), replaceSeq);
	}





	private static void generateUUID() {
		String str = UUID.randomUUID().toString();
		String str1 = str.replace("-", "");
		System.out.println(str);
		System.out.println(str1);
	}





	public static String executeLocalCommand(String command, String task, boolean logging, Logger logger) {
		logger.info("Executing command for : " + task);
		ThreadedStreamHandler errorStreamHandler = null;
		List<String> commands = new ArrayList<>();
		commands.add("/bin/sh");
		commands.add("-c");
		commands.add(command);
		StringBuilder stdout = new StringBuilder();
		try {
			InputStream is = null;

			ProcessBuilder pb = new ProcessBuilder(commands);
			Process process = pb.start();
			is = process.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			String line;
			while ((line = reader.readLine()) != null) {
				if (logging) {
					stdout.append(line + "\n");
					logger.info(line);
				}
			}
			InputStream errorStream = process.getErrorStream();
			errorStreamHandler = new ThreadedStreamHandler(errorStream);
			errorStreamHandler.start();
			errorStreamHandler.interrupt();

			errorStreamHandler.join();
			int exitStatus = process.waitFor();

			if (exitStatus == 0) {
				logger.info(task + " : Done\n");
			} else {
				if (exitStatus > 0) {
					logger.error(task + " : Error\n");
					logger.info(errorStreamHandler.getOutputBuffer());
					throw new Exception(task);
				} else {
					logger.info(task + " : Done, but exit status not set!\n");
					throw new Exception(task);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return stdout.toString();
	}





	private static void checkForNumber() {
		boolean ret = true;
		try {

			Double.parseDouble("/");

		} catch (NumberFormatException e) {
			ret = false;
		}
		System.out.println(ret);
	}





	private static void compareString() {
		String a = "aecde";
		String b = "abcde";
		System.out.println(a.compareTo(b));
	}





	private static void mergeList() {
		List<String> one = new ArrayList<>();
		one.add("a");
		one.add("b");
		List<String> two = new ArrayList<>();
		two.add("a");
		two.add("c");
		two.removeAll(one);
		one.addAll(two);
		System.out.println(one);
		System.out.println(two);
	}





	private static void fetchColumns() throws Exception {
		//				String payload = "{\n  \"size\": 0,\n  \n  \"aggs\": {\n    \"Name\": {\n      \"terms\": {\n        \"field\": \"system.process.name\",\n        \"size\": 1000,\n        \"order\": {\n          \"_key\": \"asc\"\n        }\n      },\n      \"aggs\": {\n        \"Memory\": {\n          \"avg\": {\n            \"field\": \"system.process.memory.rss.pct\"\n          }\n        },\n        \"CPU\": {\n          \"avg\": {\n            \"field\": \"system.process.cpu.total.pct\"\n          }\n        }\n      }\n    }\n  },\n  \n  \"query\": {\n    \"bool\": {\n      \"must\": [\n        \n        {\n          \"match_phrase\": {\n            \"beat.name\": {\n              \"query\": \"cape-test.southeastasia.cloudapp.azure.com\"\n            }\n          }\n        },\n        {\n          \"range\": {\n            \"@timestamp\": {\n              \"gte\": 1356584286995,\n              \"lte\": 1514350686995,\n              \"format\": \"epoch_millis\"\n            }\n          }\n        }\n      ]\n      \n    }\n  }\n  \n}";
		String payload = "{\n  \"size\": 0,\n  \"aggs\": {\n    \"total\": {\n      \"avg\": {\n        \"field\": \"system.memory.total\"\n      }\n    },\n    \"used\": {\n      \"avg\": {\n        \"script\": {\n          \"source\": \"doc[\'system.memory.total\'].value-doc[\'system.memory.free\'].value\",\n          \"lang\": \"painless\"\n        }\n      }\n    }\n  },\n  \"query\": {\n    \"bool\": {\n      \"must\": [\n        {\n          \"match_phrase\": {\n            \"beat.name\": {\n              \"query\": \"cape-test.southeastasia.cloudapp.azure.com\"\n            }\n          }\n        },\n        {\n          \"range\": {\n            \"@timestamp\": {\n              \"gte\": 1514353399073,\n              \"lte\": 1514356999073,\n              \"format\": \"epoch_millis\"\n            }\n          }\n        },\n        {\n          \"exists\": {\n            \"field\": \"system.memory\"\n          }\n        }\n      ]\n    }\n  }\n}";
		//		String payload = "{\"size\":0,\"aggs\":{\"Name\":{\"terms\":{\"field\":\"system.process.name\",\"size\":1000,\"order\":{\"Memory\":\"desc\"}},\"aggs\":{\"Memory\":{\"avg\":{\"field\":\"system.process.memory.rss.pct\"}},\"CPU\":{\"avg\":{\"field\":\"system.process.cpu.total.pct\"}}}}},\"query\":{\"bool\":{\"must\":[{\"match_phrase\":{\"beat.name\":{\"query\":\"cape-test.southeastasia.cloudapp.azure.com\"}}},{\"range\":{\"@timestamp\":{\"gte\":1513917725646,\"lte\":1514522525646,\"format\":\"epoch_millis\"}}}]}}}";
		ObjectNode key = mapper.createObjectNode();
		JsonNode jsonNode = mapper.readTree(payload);
		traverse(jsonNode, key);
		System.out.println(mapper.writeValueAsString(key));

		//				String response = "{\n  \"took\": 4,\n  \"timed_out\": false,\n  \"_shards\": {\n    \"total\": 114,\n    \"successful\": 114,\n    \"skipped\": 0,\n    \"failed\": 0\n  },\n  \"hits\": {\n    \"total\": 1270107,\n    \"max_score\": 0,\n    \"hits\": []\n  },\n  \"aggregations\": {\n    \"Name\": {\n      \"doc_count_error_upper_bound\": 0,\n      \"sum_other_doc_count\": 0,\n      \"buckets\": [\n        {\n          \"key\": \"Xvfb\",\n          \"doc_count\": 4,\n          \"Memory\": {\n            \"value\": 0.002\n          },\n          \"CPU\": {\n            \"value\": 0.01\n          }\n        },\n        {\n          \"key\": \"acpid\",\n          \"doc_count\": 1,\n          \"Memory\": {\n            \"value\": 0\n          },\n          \"CPU\": {\n            \"value\": 0\n          }\n        },\n        {\n          \"key\": \"apt-get\",\n          \"doc_count\": 10,\n          \"Memory\": {\n            \"value\": 0.003\n          },\n          \"CPU\": {\n            \"value\": 0.014300000000000002\n          }\n        },\n        {\n          \"key\": \"atd\",\n          \"doc_count\": 279,\n          \"Memory\": {\n            \"value\": 0\n          },\n          \"CPU\": {\n            \"value\": 0\n          }\n        },\n        {\n          \"key\": \"bash\",\n          \"doc_count\": 104,\n          \"Memory\": {\n            \"value\": 0.0010000000000000007\n          },\n          \"CPU\": {\n            \"value\": 0.0014326923076923084\n          }\n        },\n        {\n          \"key\": \"bzip2\",\n          \"doc_count\": 1,\n          \"Memory\": {\n            \"value\": 0.001\n          },\n          \"CPU\": {\n            \"value\": 0.026000000000000002\n          }\n        },\n        {\n          \"key\": \"check-new-relea\",\n          \"doc_count\": 1,\n          \"Memory\": {\n            \"value\": 0.004\n          },\n          \"CPU\": {\n            \"value\": 0\n          }\n        },\n        {\n          \"key\": \"chrome\",\n          \"doc_count\": 345,\n          \"Memory\": {\n            \"value\": 0.008452173913043481\n          },\n          \"CPU\": {\n            \"value\": 0.07102898550724639\n          }\n        },\n        {\n          \"key\": \"chromedriver\",\n          \"doc_count\": 156,\n          \"Memory\": {\n            \"value\": 0.0010000000000000007\n          },\n          \"CPU\": {\n            \"value\": 0.03848717948717949\n          }\n        },\n        {\n          \"key\": \"client-proxy\",\n          \"doc_count\": 53,\n          \"Memory\": {\n            \"value\": 0.0010000000000000005\n          },\n          \"CPU\": {\n            \"value\": 0.0010000000000000005\n          }\n        },\n        {\n          \"key\": \"copy\",\n          \"doc_count\": 1,\n          \"Memory\": {\n            \"value\": 0\n          },\n          \"CPU\": {\n            \"value\": 0.07\n          }\n        },\n        {\n          \"key\": \"cron\",\n          \"doc_count\": 13,\n          \"Memory\": {\n            \"value\": 0\n          },\n          \"CPU\": {\n            \"value\": 0.0003846153846153846\n          }\n        },\n        {\n          \"key\": \"dbus-daemon\",\n          \"doc_count\": 18,\n          \"Memory\": {\n            \"value\": 0\n          },\n          \"CPU\": {\n            \"value\": 0.0016111111111111111\n          }\n        },\n        {\n          \"key\": \"dhclient\",\n          \"doc_count\": 897,\n          \"Memory\": {\n            \"value\": 0\n          },\n          \"CPU\": {\n            \"value\": 0\n          }\n        },\n        {\n          \"key\": \"dirmngr\",\n          \"doc_count\": 507,\n          \"Memory\": {\n            \"value\": 0\n          },\n          \"CPU\": {\n            \"value\": 0.0009980276134122295\n          }\n        },\n        {\n          \"key\": \"docker\",\n          \"doc_count\": 10,\n          \"Memory\": {\n            \"value\": 0.0010000000000000002\n          },\n          \"CPU\": {\n            \"value\": 0.0015000000000000005\n          }\n        },\n        {\n          \"key\": \"docker-containe\",\n          \"doc_count\": 21665,\n          \"Memory\": {\n            \"value\": 0.0009655665820447323\n          },\n          \"CPU\": {\n            \"value\": 0.002324994230325381\n          }\n        },\n        {\n          \"key\": \"docker-machine\",\n          \"doc_count\": 211,\n          \"Memory\": {\n            \"value\": 0.0016919431279620865\n          },\n          \"CPU\": {\n            \"value\": 0.001085308056872038\n          }\n        },\n        {\n          \"key\": \"docker-proxy\",\n          \"doc_count\": 2,\n          \"Memory\": {\n            \"value\": 0\n          },\n          \"CPU\": {\n            \"value\": 0.018000000000000002\n          }\n        },\n        {\n          \"key\": \"dockerd\",\n          \"doc_count\": 30264,\n          \"Memory\": {\n            \"value\": 0.004041071900607969\n          },\n          \"CPU\": {\n            \"value\": 0.02711393074279623\n          }\n        },\n        {\n          \"key\": \"dpkg\",\n          \"doc_count\": 9,\n          \"Memory\": {\n            \"value\": 0.0022222222222222222\n          },\n          \"CPU\": {\n            \"value\": 0.09266666666666666\n          }\n        },\n        {\n          \"key\": \"dpkg-deb\",\n          \"doc_count\": 7,\n          \"Memory\": {\n            \"value\": 0\n          },\n          \"CPU\": {\n            \"value\": 0.030000000000000002\n          }\n        },\n        {\n          \"key\": \"exe\",\n          \"doc_count\": 3,\n          \"Memory\": {\n            \"value\": 0.002\n          },\n          \"CPU\": {\n            \"value\": 0\n          }\n        },\n        {\n          \"key\": \"htop\",\n          \"doc_count\": 176,\n          \"Memory\": {\n            \"value\": 0\n          },\n          \"CPU\": {\n            \"value\": 0.006318181818181817\n          }\n        },\n        {\n          \"key\": \"http\",\n          \"doc_count\": 1,\n          \"Memory\": {\n            \"value\": 0\n          },\n          \"CPU\": {\n            \"value\": 0.002\n          }\n        },\n        {\n          \"key\": \"hv_kvp_daemon\",\n          \"doc_count\": 223,\n          \"Memory\": {\n            \"value\": 0\n          },\n          \"CPU\": {\n            \"value\": 0.0010044843049327361\n          }\n        },\n        {\n          \"key\": \"hv_vss_daemon\",\n          \"doc_count\": 304,\n          \"Memory\": {\n            \"value\": 0\n          },\n          \"CPU\": {\n            \"value\": 0\n          }\n        },\n        {\n          \"key\": \"init\",\n          \"doc_count\": 5399,\n          \"Memory\": {\n            \"value\": 0.00038451565104648\n          },\n          \"CPU\": {\n            \"value\": 0.0020440822374513615\n          }\n        },\n        {\n          \"key\": \"irqbalance\",\n          \"doc_count\": 240,\n          \"Memory\": {\n            \"value\": 0\n          },\n          \"CPU\": {\n            \"value\": 0.0009791666666666675\n          }\n        },\n        {\n          \"key\": \"java\",\n          \"doc_count\": 55277,\n          \"Memory\": {\n            \"value\": 0.052007815185338174\n          },\n          \"CPU\": {\n            \"value\": 0.014991551639922118\n          }\n        },\n        {\n          \"key\": \"logrotate\",\n          \"doc_count\": 12,\n          \"Memory\": {\n            \"value\": 0\n          },\n          \"CPU\": {\n            \"value\": 0.007250000000000002\n          }\n        },\n        {\n          \"key\": \"metricbeat\",\n          \"doc_count\": 35547,\n          \"Memory\": {\n            \"value\": 0.0028549244661997316\n          },\n          \"CPU\": {\n            \"value\": 0.005772048274116002\n          }\n        },\n        {\n          \"key\": \"node\",\n          \"doc_count\": 2735,\n          \"Memory\": {\n            \"value\": 0.006334186471663698\n          },\n          \"CPU\": {\n            \"value\": 0.004226325411334516\n          }\n        },\n        {\n          \"key\": \"nscd\",\n          \"doc_count\": 5986,\n          \"Memory\": {\n            \"value\": 0\n          },\n          \"CPU\": {\n            \"value\": 0.0011045773471433317\n          }\n        },\n        {\n          \"key\": \"ntpd\",\n          \"doc_count\": 631,\n          \"Memory\": {\n            \"value\": 0\n          },\n          \"CPU\": {\n            \"value\": 0.0010000000000000007\n          }\n        },\n        {\n          \"key\": \"omiagent\",\n          \"doc_count\": 8784,\n          \"Memory\": {\n            \"value\": 0.010866917122040022\n          },\n          \"CPU\": {\n            \"value\": 0.08985280054644794\n          }\n        },\n        {\n          \"key\": \"omiserver\",\n          \"doc_count\": 341,\n          \"Memory\": {\n            \"value\": 0.00008211143695014668\n          },\n          \"CPU\": {\n            \"value\": 0.017809384164222876\n          }\n        },\n        {\n          \"key\": \"omsagent-797316\",\n          \"doc_count\": 28642,\n          \"Memory\": {\n            \"value\": 0.012613749039871556\n          },\n          \"CPU\": {\n            \"value\": 0.0021724041617205464\n          }\n        },\n        {\n          \"key\": \"plymouth-upstar\",\n          \"doc_count\": 1,\n          \"Memory\": {\n            \"value\": 0\n          },\n          \"CPU\": {\n            \"value\": 0\n          }\n        },\n        {\n          \"key\": \"plymouthd\",\n          \"doc_count\": 1,\n          \"Memory\": {\n            \"value\": 0\n          },\n          \"CPU\": {\n            \"value\": 0\n          }\n        },\n        {\n          \"key\": \"python\",\n          \"doc_count\": 2,\n          \"Memory\": {\n            \"value\": 0.001\n          },\n          \"CPU\": {\n            \"value\": 0.0035\n          }\n        },\n        {\n          \"key\": \"python3\",\n          \"doc_count\": 53072,\n          \"Memory\": {\n            \"value\": 0.0016991822429905747\n          },\n          \"CPU\": {\n            \"value\": 0.0042078685559240716\n          }\n        },\n        {\n          \"key\": \"rsyslogd\",\n          \"doc_count\": 208,\n          \"Memory\": {\n            \"value\": 0\n          },\n          \"CPU\": {\n            \"value\": 0.0010096153846153853\n          }\n        },\n        {\n          \"key\": \"sftp-server\",\n          \"doc_count\": 39,\n          \"Memory\": {\n            \"value\": 0\n          },\n          \"CPU\": {\n            \"value\": 0.0017179487179487187\n          }\n        },\n        {\n          \"key\": \"sshd\",\n          \"doc_count\": 770,\n          \"Memory\": {\n            \"value\": 0.000009090909090909091\n          },\n          \"CPU\": {\n            \"value\": 0.0013597402597402605\n          }\n        },\n        {\n          \"key\": \"start.sh\",\n          \"doc_count\": 1470,\n          \"Memory\": {\n            \"value\": 0\n          },\n          \"CPU\": {\n            \"value\": 0.0010721088435374157\n          }\n        },\n        {\n          \"key\": \"systemd-logind\",\n          \"doc_count\": 57,\n          \"Memory\": {\n            \"value\": 0\n          },\n          \"CPU\": {\n            \"value\": 0.0019473684210526325\n          }\n        },\n        {\n          \"key\": \"systemd-udevd\",\n          \"doc_count\": 321,\n          \"Memory\": {\n            \"value\": 0\n          },\n          \"CPU\": {\n            \"value\": 0.00003738317757009346\n          }\n        },\n        {\n          \"key\": \"top\",\n          \"doc_count\": 833,\n          \"Memory\": {\n            \"value\": 0\n          },\n          \"CPU\": {\n            \"value\": 0.0013637454981992806\n          }\n        },\n        {\n          \"key\": \"update-apt-xapi\",\n          \"doc_count\": 1,\n          \"Memory\": {\n            \"value\": 0.015\n          },\n          \"CPU\": {\n            \"value\": 0.638\n          }\n        },\n        {\n          \"key\": \"update-mime-dat\",\n          \"doc_count\": 1,\n          \"Memory\": {\n            \"value\": 0.004\n          },\n          \"CPU\": {\n            \"value\": 0.007\n          }\n        },\n        {\n          \"key\": \"updatedb.mlocat\",\n          \"doc_count\": 8,\n          \"Memory\": {\n            \"value\": 0\n          },\n          \"CPU\": {\n            \"value\": 0.0325\n          }\n        },\n        {\n          \"key\": \"upstart-file-br\",\n          \"doc_count\": 10,\n          \"Memory\": {\n            \"value\": 0\n          },\n          \"CPU\": {\n            \"value\": 0.0014000000000000002\n          }\n        },\n        {\n          \"key\": \"upstart-socket-\",\n          \"doc_count\": 147,\n          \"Memory\": {\n            \"value\": 0\n          },\n          \"CPU\": {\n            \"value\": 0.000272108843537415\n          }\n        },\n        {\n          \"key\": \"upstart-udev-br\",\n          \"doc_count\": 54,\n          \"Memory\": {\n            \"value\": 0\n          },\n          \"CPU\": {\n            \"value\": 0.000925925925925926\n          }\n        },\n        {\n          \"key\": \"vi\",\n          \"doc_count\": 36,\n          \"Memory\": {\n            \"value\": 0.0010000000000000005\n          },\n          \"CPU\": {\n            \"value\": 0.005083333333333336\n          }\n        },\n        {\n          \"key\": \"wrapper\",\n          \"doc_count\": 43,\n          \"Memory\": {\n            \"value\": 0\n          },\n          \"CPU\": {\n            \"value\": 0.0015581395348837214\n          }\n        }\n      ]\n    }\n  }\n}";
		String response = "{\n  \"took\": 4,\n  \"timed_out\": false,\n  \"_shards\": {\n    \"total\": 124,\n    \"successful\": 124,\n    \"skipped\": 0,\n    \"failed\": 0\n  },\n  \"hits\": {\n    \"total\": 360,\n    \"max_score\": 0,\n    \"hits\": []\n  },\n  \"aggregations\": {\n    \"total\": {\n      \"value\": 14694846464\n    },\n    \"used\": {\n      \"value\": 11524344649.955555\n    }\n  }\n}";
		JsonNode responseBody = mapper.readTree(response).get("aggregations");

		List<List<String>> columns = new ArrayList<>();
		List<String> column = new ArrayList<>();
		setColumns(key, responseBody, columns, column, false);
		//		System.out.println(column);
		System.out.println(columns);

	}





	private static void traverseJson() throws Exception {
		String payload = "{\n  \"size\": 0,\n  \"aggs\": {\n    \"total\": {\n      \"avg\": {\n        \"field\": \"system.memory.total\"\n      }\n    },\n    \"used\": {\n      \"avg\": {\n        \"script\": {\n          \"source\": \"doc[\'system.memory.total\'].value-doc[\'system.memory.free\'].value\",\n          \"lang\": \"painless\"\n        }\n      }\n    }\n  },\n  \"query\": {\n    \"bool\": {\n      \"must\": [\n        {\n          \"match_phrase\": {\n            \"beat.name\": {\n              \"query\": \"cape-test.southeastasia.cloudapp.azure.com\"\n            }\n          }\n        },\n        {\n          \"range\": {\n            \"@timestamp\": {\n              \"gte\": 1514353399073,\n              \"lte\": 1514356999073,\n              \"format\": \"epoch_millis\"\n            }\n          }\n        },\n        {\n          \"exists\": {\n            \"field\": \"system.memory\"\n          }\n        }\n      ]\n    }\n  }\n}";
		ObjectNode key = mapper.createObjectNode();
		JsonNode jsonNode = mapper.readTree(payload);
		traverse(jsonNode, key);
		System.out.println(mapper.writeValueAsString(key));
	}





	public static void traverse(JsonNode payload, ObjectNode key) throws Exception {
		try {
			if (payload.get("aggs") != null) {

				JsonNode aggs = payload.get("aggs");
				Iterator<Entry<String, JsonNode>> fieldItr = aggs.fields();
				while (fieldItr.hasNext()) {
					Entry<String, JsonNode> currEntry = fieldItr.next();
					String currKey = currEntry.getKey();
					if (StringUtils.isNotEmpty(currKey)) {
						key.set(currKey, mapper.createObjectNode());
						traverse(aggs.get(currKey), (ObjectNode) key.get(currKey));
					}

				}

			}
		} catch (Exception e) {
			throw new Exception("Error parsing json");
		}
	}





	public static void setColumns(JsonNode key, JsonNode response, List<List<String>> columns, List<String> column,
			boolean previousBucket) throws Exception {
		try {
			if (response != null) {
				boolean hasBucket = false;
				//				boolean alreadyAdded = false;
				Iterator<Entry<String, JsonNode>> fieldItr = key.fields();
				while (fieldItr.hasNext()) {
					Entry<String, JsonNode> currEntry = fieldItr.next();
					if (currEntry != null) {
						String currKey = currEntry.getKey();
						if (StringUtils.isNotEmpty(currKey)) {
							Iterator<Entry<String, JsonNode>> nextFieldItr = key.get(currKey).fields();
							if (nextFieldItr.hasNext()) {
								Iterator<JsonNode> bucketsIterator = response.get(currKey).get("buckets").elements();
								while (bucketsIterator.hasNext()) {
									previousBucket = true;
									hasBucket = true;
									JsonNode bucket = bucketsIterator.next();
									column.add(bucket.get("key").asText());
									setColumns(key.get(currKey), bucket, columns, column, previousBucket);
									columns.add(column);
									column = new ArrayList<>();
									//									alreadyAdded = true;
								}
							} else {
								column.add(response.get(currKey).get("value").asText());
							}
						}
					}
					if (!hasBucket && !previousBucket) {
						columns.add(column);
						column = new ArrayList<>();
					}
				}
			}
		} catch (Exception e) {
			throw new Exception("Error parsing json");
		}
	}





	public static void characterDifference() {
		System.out.println("RGVwbG95aW5nIENvZGUgUGFja2FnZSAtIENNIFNlcnZlcnM="
				.compareTo("RGVwbG95aW5nIENvZGUgUGFja2FnZSAtIENEIFNlcnZlcnM="));

	}





	public static void findInStringArray() {
		String[] list = { "a", "b", "c", "d" };
		System.out.println(Arrays.asList(list).contains("ba"));

	}





	public static void base32() {
		String data = "____===abcd!@#$56&*()987654RTDFJHB@#$%%^&*FDGJHjaskdkas==";
		System.out.println(data);
		String encoded = StringUtils.replace(new Base32().encodeToString(data.getBytes()), "=", "_");
		System.out.println(encoded);
		String decoded = new String(new Base32().decode(StringUtils.replace(encoded, "_", "=")));
		System.out.println(decoded);
		System.out.println(decoded.equals(data));

	}





	public static void checkClass() {
		System.out.println(String.class.isInstance(new String()));

	}





	public static void testReplace() {
		String data = "abcd./!@#$623!@#$%^&*()_+==++\\//";
		System.out.println(StringUtils.replaceEach(new String(Base64.getEncoder()
				.encode(data.getBytes())), new String[] { "+", "/", "=" }, new String[] { "_", "_", "_" }));

	}





	public static void jacksontest() throws JsonParseException, JsonMappingException, IOException {
		String json = "[{\"createdBy\":\"M1037547@mindtree.com\",\"createdOn\":1507097610405,\"lastUpadateBy\":\"M1000668@mindtree.com\",\"lastUpdatedOn\":1509100079866,\"score\":0,\"categoryCode\":\"CAT9df488d5865b47a6bf29c8fe74e1a79e\",\"categoryName\":\"Virtual Machines\",\"color\":\"#459b6f\"},{\"createdBy\":\"M1000668@mindtree.com\",\"createdOn\":1507879173778,\"lastUpadateBy\":\"M1000668@mindtree.com\",\"lastUpdatedOn\":1507888016191,\"score\":0,\"categoryCode\":\"CAT9e5e14c02b664a5c962c0c4fa279e4ed\",\"categoryName\":\"RUN\",\"color\":\"#e88c4d\"},{\"createdBy\":\"M1000668@mindtree.com\",\"createdOn\":1507879816743,\"lastUpadateBy\":\"M1000668@mindtree.com\",\"lastUpdatedOn\":1510313467806,\"score\":0,\"categoryCode\":\"CATb222d268e24d408f81f950ced6a0d298\",\"categoryName\":\"SERVER\",\"color\":\"#f9b2b2\"},{\"createdBy\":\"M1000668@mindtree.com\",\"createdOn\":1507879932903,\"lastUpadateBy\":\"M1000668@mindtree.com\",\"lastUpdatedOn\":1509099396058,\"score\":0,\"categoryCode\":\"CAT4b8652076fd3466f87cc2d19491a428e\",\"categoryName\":\"BUILD\",\"color\":\"#ffd454\"},{\"createdBy\":\"M1000668@mindtree.com\",\"createdOn\":1507879988901,\"lastUpadateBy\":\"M1000668@mindtree.com\",\"lastUpdatedOn\":1509100066521,\"score\":0,\"categoryCode\":\"CAT94fea3ab13994ac1a52e54e2545d5081\",\"categoryName\":\"CONFIG\",\"color\":\"#ede84c\"},{\"createdBy\":\"M1000668@mindtree.com\",\"createdOn\":1507880287374,\"lastUpadateBy\":\"M1000668@mindtree.com\",\"lastUpdatedOn\":1510313439101,\"score\":0,\"categoryCode\":\"CAT5a04582a0ca6476abb31ba3efaf49bb2\",\"categoryName\":\"TEST\",\"color\":\"#ff6473\"},{\"createdBy\":\"M1000668@mindtree.com\",\"createdOn\":1507884576088,\"lastUpadateBy\":\"M1000668@mindtree.com\",\"lastUpdatedOn\":1509100075940,\"score\":0,\"categoryCode\":\"CAT0b5f915d9dff4db8a888214a2dbc20d2\",\"categoryName\":\"PLAN\",\"color\":\"#5facd3\"},{\"createdBy\":\"M1000668@mindtree.com\",\"createdOn\":1507880252636,\"lastUpadateBy\":\"M1000668@mindtree.com\",\"lastUpdatedOn\":1507888024281,\"score\":0,\"categoryCode\":\"CATca9af9b16a8647788c2d5fd91d61d82a\",\"categoryName\":\"DEPLOY\",\"color\":\"#7cd36a\"},{\"createdBy\":\"root@cape.com\",\"createdOn\":1509703442407,\"lastUpadateBy\":null,\"lastUpdatedOn\":null,\"score\":0,\"categoryCode\":\"CAT402c455292934759aa230e59b16249f3\",\"categoryName\":\"testing\",\"color\":\"#ffd454\"},{\"createdBy\":\"root@cape.com\",\"createdOn\":1509703502642,\"lastUpadateBy\":null,\"lastUpdatedOn\":null,\"score\":0,\"categoryCode\":\"CAT2304e9c141f44d81b233ae7c0b4bd45b\",\"categoryName\":\"testing123\",\"color\":\"#ffd454\"}]";
		System.out.println(mapper.readValue(json, String.class));
	}





	public static void splitMulti() {
		String data = "abcd_!_efg_!_hij_!_klm_!_nop_!_asd";
		System.out.println(StringUtils.splitByWholeSeparator(data, "_!_").length);
		System.out.println(data.split("_!_").length);

	}





	public static void urlencode() throws UnsupportedEncodingException {
		String url = "http://jenkins.pgsitecore.com:8080/job/RP-GM%201.22.1/buildWithParameters?CurrentBranch=ExpressRelease_SC8.2&PreviousBuildTagName=GM-1.21-FinalBuild&AppVersion=1.22.1&NugetRepository=NonProduction&Instance=SharedABBs&Project=RP&DeployTo=BrandCMS3&Skippackage=\"Skip+\"Deploy_Brand.com_Sitecore_Package\"+--Skip+\"Sitecore-Install_Sitecore_Update_Package-Brand.com\"+--Skip+\"HTTP-Test+URL_+After_Brand_items_installation\"+--Skip+\"Deploy_Brand.com_Code_Package-CM\"+--Skip+\"HTTP-Test_URL-After_Brand_Installation\"+--Skip+\"Deploy_Brand.com_Code_Package-CD\"+--Skip+HTTP-Test_URL-After_Brand_Installation_on_CD\"&SCItemPackage=Deploy_RP_Sitecore_Package&CMCodepackage=Deploy_RP_Code_Package-CM&CDCodepackage=Deploy_RP_Code_Package-CD";
		String url1 = "https://octopus.pgsitecore.com/api/feeds/feeds-sk-ii/packages?packageId=PG.SKII.Code.CM&partialMatch=false&includeMultipleVersions=true&includeNotes=false&includePreRelease=true&versionRange=(0.0.0.1,10.0.0.0)&preReleaseTag=UAT&take=1000";
		String url2 = "(0.0.0.1,10.0.0.0)";

		System.out.println(url2);

		String test = "something = \"SDfsdf\"sdf & =sdfsdf sdf34\"sdf sf sdf?&=,";
		System.out.println(URLEncoder.encode(url2, "UTF-8"));
		System.out.println(URLDecoder.decode(URLEncoder.encode(url2, "UTF-8"), "UTF-8"));

	}





	public static void humanReadableTime(Long millis) {
		//		String result = String.format("%d min, %d sec", TimeUnit.MILLISECONDS.toMinutes(millis), TimeUnit.MILLISECONDS
		//				.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
		//		System.out.println(result);

		if (millis < 0) {
			throw new IllegalArgumentException("Duration must be greater than zero!");
		}

		long days = TimeUnit.MILLISECONDS.toDays(millis);
		millis -= TimeUnit.DAYS.toMillis(days);
		long hours = TimeUnit.MILLISECONDS.toHours(millis);
		millis -= TimeUnit.HOURS.toMillis(hours);
		long minutes = TimeUnit.MILLISECONDS.toMinutes(millis);
		millis -= TimeUnit.MINUTES.toMillis(minutes);
		long seconds = TimeUnit.MILLISECONDS.toSeconds(millis);

		StringBuilder sb = new StringBuilder(64);
		if (days != 0) {
			sb.append(days);
			sb.append(" Days ");
		}
		if (hours != 0) {
			sb.append(hours);
			sb.append(" Hours ");
		}
		if (minutes != 0) {
			sb.append(minutes);
			sb.append(" Minutes ");
		}
		if (seconds != 0) {
			sb.append(seconds);
			sb.append(" Seconds");
		}

		System.out.println(sb);
	}





	public static void humanReadableTime(Duration duration) {
		System.out.println(duration.toString().substring(2).replaceAll("(\\d[HMS])(?!$)", "$1 ").toLowerCase());
	}





	public static void testUrl() {
		try {
			URL u = new URL("http://cape-vm-two.southeastasia.cloudapp.azure.com/nagios/ ");
			HttpURLConnection huc = (HttpURLConnection) u.openConnection();
			huc.setRequestMethod("HEAD"); //OR  huc.setRequestMethod ("HEAD");
			huc.connect();
			int code = huc.getResponseCode();
			System.out.println(code);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getClass().getCanonicalName());
		}
	}





	public static void checkSet() {
		Set<String> data = new HashSet<>();
		data.add("1");
		data.add("1");
		System.out.println(data);
	}





	public static void checkLong() {

		Long l = new Long("3f3");
		System.out.println(l);

	}





	public static void getOctopusLogs() throws IOException {
		int count = 1;
		while (true) {
			Client client = Client.create();
			String releaseUri = "http://octopus.test.pgsitecore.com/api/tasks/ServerTasks-14991";
			WebResource webResource = client.resource(releaseUri);
			ClientResponse response = webResource.header("X-Octopus-ApiKey", "API-G7SQ4HFXXEPVOQEQYQXVEYZGZC")
					.type("application/json").get(ClientResponse.class);
			String responseData = response.getEntity(String.class);
			System.out.println(mapper.readTree(responseData).get("State").asText());
			if (response.getStatus() != 200) {
				break;
			}

			String releaseUri1 = "http://octopus.test.pgsitecore.com/api/tasks/ServerTasks-14991/raw";
			WebResource webResource1 = client.resource(releaseUri1);
			ClientResponse response1 = webResource1.header("X-Octopus-ApiKey", "API-G7SQ4HFXXEPVOQEQYQXVEYZGZC")
					.type("application/json").get(ClientResponse.class);
			String responseData1 = response1.getEntity(String.class);
			if (response1.getStatus() != 200) {
				break;
			}
			System.out.println(responseData1.substring(0, 100));
			System.out.println("API count: " + count++);
		}
		System.out.println("API stopped");
	}





	public static void testString() {
		String test = "yes";
		if (!test.equalsIgnoreCase("yes")) {
			System.out.println("True");
		} else {
			System.out.println("False");
		}
	}





	public static void testPatch() {
		String uri = "http://demo4520744.mockable.io/vsts";
		HttpHeaders headers = new HttpHeaders();
		MediaType mediaType = new MediaType("application", "merge-patch+json");
		headers.setContentType(mediaType);

		HttpEntity<String> entity = new HttpEntity<>("abc", headers);
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		RestTemplate restTemplate = new RestTemplate(requestFactory);

		ResponseEntity<String> buildResponse = restTemplate.exchange(uri, HttpMethod.PATCH, entity, String.class);

		System.out.println(buildResponse.getBody());
	}





	public static void deleteAllServiceEndpoints() throws IOException {

		String url = "https://pankaj-vsts.visualstudio.com/DefaultCollection/MyFirstProject";
		String apiToken = "Y2FwZS5kZXZ0ZWFtQGdtYWlsLmNvbTpzcWM2NHAyaXZjaWk2YnNxY2tic25uaDZxanpzNDJyenQ1YjZncXdua29yMnU0MzR6ZTRh";

		String allEndpointsData = getServiceEndpoint(url, apiToken);

		Iterator<JsonNode> elements = mapper.readTree(allEndpointsData).get("value").elements();

		while (elements.hasNext()) {

			JsonNode node = elements.next();
			//			deleteServiceEndpoint(node.get("id").asText(), url, apiToken);

		}

	}





	public static String getServiceEndpoint(String url, String apiToken) {
		Client client = Client.create();
		String releaseUri = url + "/_apis/distributedtask/serviceendpoints?api-version=3.0-preview.1";
		WebResource webResource = client.resource(releaseUri);
		ClientResponse response = webResource.header("Authorization", "Basic " + apiToken).type("application/json")
				.get(ClientResponse.class);
		String responseData = response.getEntity(String.class);
		if (response.getStatus() != 200) {
		}
		return responseData;
	}





	public static void deleteServiceEndpoint(String id, String baseUrl, String apiToken) {
		Client client = Client.create();
		String releaseUri = baseUrl + "/_apis/distributedtask/serviceendpoints/" + id + "?api-version=3.0-preview.1";
		WebResource webResource = client.resource(releaseUri);
		ClientResponse response = webResource.header("Authorization", "Basic " + apiToken).type("application/json")
				.delete(ClientResponse.class);
	}





	public static void checkException() {
		String url = null;
		try {
			url.charAt(0);
		} catch (Exception e) {
			//			e.printStackTrace(pw);
			//			sw.toString();
			//			System.out.println("" + sw.toString());
			System.out.println(extrapolateStackTrace(e));
		}

		try {
			throw new Exception("Hello");
		} catch (Exception e) {
			//			StringWriter sw = new StringWriter();
			//			PrintWriter pw = new PrintWriter(sw);
			//			e.printStackTrace(pw);
			//			sw.toString();
			//			System.out.println("" + sw.toString());
			System.out.println(extrapolateStackTrace(e));
		}

		try {
			throw new Exception("dfgfdg");
		} catch (Exception e) {
			//			StringWriter sw = new StringWriter();
			//			PrintWriter pw = new PrintWriter(sw);
			//			e.printStackTrace(pw);
			//			sw.toString();
			//			System.out.println("" + sw.toString());
			System.out.println(extrapolateStackTrace(e));
		}
	}





	public static String extrapolateStackTrace(Exception ex) {
		Throwable e = ex;
		String trace = e.toString() + "\n";
		for (StackTraceElement e1 : e.getStackTrace()) {
			trace += "\t at " + e1.toString() + "\n";
		}
		while (e.getCause() != null) {
			e = e.getCause();
			trace += "Cause by: " + e.toString() + "\n";
			for (StackTraceElement e1 : e.getStackTrace()) {
				trace += "\t at " + e1.toString() + "\n";
			}
		}
		return trace;
	}





	public static void getBasePath() {
		String path = "\\CapeTest\\CapeTest.csproj";
		if (path.startsWith("\\")) {
			path = path.substring(1);
		}
		String basePath = path.substring(0, path.indexOf("\\"));
		System.out.println(basePath);
	}





	public static void addHttp() {
		String baseUrl = "cape-vsts.southeastasia.cloudapp.azure.com";
		if (!baseUrl.contains("http://") && !baseUrl.contains("https://")) {
			baseUrl = "http://" + baseUrl;
		}
		if (!baseUrl.contains("https://") && !baseUrl.contains("http://")) {
			baseUrl = "https://" + baseUrl;
		}
		System.out.println(baseUrl);
	}





	public static void createDynamicForm() throws IOException {
		String schemaForm = "{\"form\":[\"releaseNumber\"],\"schema\":{\"type\":\"object\",\"properties\":{\"releaseNumber\":{\"title\":\"Release number\",\"type\":\"string\"}},\"required\":[\"releaseNumber\"]}}";

		JsonNode schemaFormNode = mapper.readTree(schemaForm);
		ArrayNode formNode = (ArrayNode) schemaFormNode.get("form");
		JsonNode schemaNode = schemaFormNode.get("schema");

		for (int i = 1; i < 4; i++) {
			formNode.add("step" + i);
			ArrayNode requiredNode = (ArrayNode) schemaNode.get("required");
			requiredNode.add("step" + i);

			ObjectNode properties = (ObjectNode) schemaNode.get("properties");
			ObjectNode step = mapper.createObjectNode();
			step.put("title", "MyStep" + i);
			step.put("type", "string");
			step.put("default", "23");

			ArrayNode enumValue = step.putArray("enum");
			enumValue.add("21");
			enumValue.add("22");
			enumValue.add("23");
			enumValue.add("24");

			properties.set("step" + i, step);

		}

		ObjectNode properties = (ObjectNode) schemaNode.get("properties");
		ObjectNode step = mapper.createObjectNode();
		step.put("title", "MyStep");
		step.put("type", "string");
		step.put("default", "23");
		properties.set("val", step);

		ObjectNode releaseNumber = (ObjectNode) schemaNode.get("properties").get("releaseNumber");
		releaseNumber.put("default", "123");

		ObjectNode button = mapper.createObjectNode();
		button.put("type", "submit");
		button.put("style", "btn-info");
		button.put("title", "Apply");

		formNode.add(button);

		System.out.println(mapper.writeValueAsString(schemaFormNode));
	}





	public static void loggerUtil() {

		Logger logger = getLogger("logs/test");
		for (int i = 0; i < 100; i++) {
			logger.info("Test " + i);
		}
		logger = getLogger("logs/test");
	}





	public static Logger getLogger(String loggerName) {
		String logFile = loggerName + ".log";
		Logger logger = Logger.getLogger(loggerName);
		Properties props = new Properties();
		props.setProperty("log4j.appender.file", "org.apache.log4j.FileAppender");
		props.setProperty("log4j.appender.file.File", logFile);
		props.setProperty("log4j.appender.file.threshold", "debug");
		props.setProperty("log4j.appender.file.layout", "org.apache.log4j.PatternLayout");
		props.setProperty("log4j.appender.file.layout.ConversionPattern", "%d %t %p %C{1}.%M.%L : %m%n");
		props.setProperty("log4j.appender.file.Append", "false");
		props.setProperty("log4j.appender.stdout", "org.apache.log4j.ConsoleAppender");
		props.setProperty("log4j.appender.stdout.Target", "System.out");
		props.setProperty("log4j.appender.stdout.layout", "org.apache.log4j.PatternLayout");
		props.setProperty("log4j.appender.stdout.layout.ConversionPattern", "%d %t %p %C{1}.%M.%L : %m%n");
		/*		props.setProperty("log4j.appender.MongoDB", "org.log4mongo.MongoDbAppender");
				props.setProperty("log4j.appender.MongoDB.hostname", "cape-build-server.southeastasia.cloudapp.azure.com");
				props.setProperty("log4j.appender.MongoDB.port", "27017");
				props.setProperty("log4j.appender.MongoDB.databaseName", "devOpsLog");
				props.setProperty("log4j.appender.MongoDB.collectionName", "log");*/
		props.setProperty("log4j.logger." + loggerName, "INFO, file, stdout");
		PropertyConfigurator.configure(props);
		return logger;
	}





	public static void splitRoles() {
		String roles = "";
		List<String> rol = Arrays.asList(roles.split(","));
		System.out.println(rol);
		String[] split = roles.split(",");
		System.out.println(split.length + "   " + roles.split(",") + "  " + split[0]);
		String test = "";
		String[] split2 = StringUtils.split(test, ",");
		System.out.println(split2.length + "   ");
		System.out.println("abcd".split(",").length);
	}





	public static void jackson() throws IOException {
		String data = "{\"ItemType\":\"Deployment\",\"IsStale\":false,\"TotalResults\":1,\"ItemsPerPage\":30,\"Items\":[{\"Id\":\"Deployments-48\",\"ReleaseId\":\"Releases-50\",\"EnvironmentId\":\"Environments-1\",\"TenantId\":null,\"ForcePackageDownload\":false,\"ForcePackageRedeployment\":false,\"SkipActions\":[],\"SpecificMachineIds\":[],\"ExcludedMachineIds\":[],\"DeploymentProcessId\":\"deploymentprocess-Projects-1-s-15-FX2JZ\",\"ManifestVariableSetId\":\"variableset-Deployments-48\",\"TaskId\":\"ServerTasks-520\",\"ProjectId\":\"Projects-1\",\"ChannelId\":\"Channels-1\",\"UseGuidedFailure\":false,\"Comments\":null,\"FormValues\":{},\"QueueTime\":null,\"QueueTimeExpiry\":null,\"Name\":\"Deploy to DEV\",\"Created\":\"2017-05-31T12:19:42.956+00:00\",\"Links\":{\"Self\":\"/api/deployments/Deployments-48\",\"Release\":\"/api/releases/Releases-50\",\"Environment\":\"/api/environments/Environments-1\",\"Project\":\"/api/projects/Projects-1\",\"Task\":\"/api/tasks/ServerTasks-520\",\"Web\":\"/app#/deployments/Deployments-48\",\"Artifacts\":\"/api/artifacts?regarding=Deployments-48\",\"Interruptions\":\"/api/interruptions?regarding=Deployments-48\",\"Variables\":\"/api/variables/variableset-Deployments-48\"}}],\"Links\":{\"Self\":\"/api/releases/Releases-50/deployments\",\"Template\":\"/api/releases/Releases-50/deployments\",\"Page.Current\":\"/api/releases/Releases-50/deployments?skip=0\",\"Page.0\":\"/api/releases/Releases-50/deployments?skip=0\"}}";

		System.out.println(mapper.readTree(data).get("Links").get("Page.Current"));

		String data1 = "{\"ItemType\":\"Interruption\",\"IsStale\":false,\"TotalResults\":2,\"ItemsPerPage\":30,\"Items\":[]}";

		System.out.println(mapper.readTree(data1).get("Items").get(0));

	}





	public static void dateFormat() throws ParseException {
		String dateString = "2017-06-07T09:55:58.967+00:00";
		String dateString1 = "2017-06-07T09:56:09.634+00:00";
		String pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date date = sdf.parse(dateString);
		Date date1 = sdf.parse(dateString1);
		System.out.println(date1.getTime());
		System.out.println(date.getTime());
		System.out.println((int) Math.ceil((date1.getTime() - date.getTime()) / 1000.0));
		System.out.println(date); // Mon Mar 01 00:00:00 BOT 2010

		System.out.println("s{/version}{?skip}".toUpperCase());
	}





	public static void removeExtraChar() {
		String baseUrl1 = "s{/version}{?skip}";
		StringBuilder baseUrl = new StringBuilder(baseUrl1);
		System.out.println(baseUrl1);
		while (baseUrl1.contains("{")) {
			baseUrl = baseUrl.replace(baseUrl1.indexOf("{"), baseUrl1.indexOf("}") + 1, "");
			baseUrl1 = baseUrl.toString();
		}
		System.out.println(baseUrl1);
	}


}
