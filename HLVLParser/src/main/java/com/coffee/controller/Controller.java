package com.coffee.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@org.springframework.web.bind.annotation.RestController
public class Controller {

	public final static String DIR = System.getProperty("user.dir");
	private final static String HLVL_DIR = "/hlvl/";

	@Autowired
	FileManager fileCreator;

	@Autowired
	CmdExecutor executor;

	@CrossOrigin
	@RequestMapping(value = "/coffeeHLVLP/hlvlParser", method = RequestMethod.POST, produces = "text/plain")
	@ResponseBody
	public String hlvlParser(@RequestBody JSONObject data) throws Exception {
		System.out.println("YA llego la peticion");
		String content = (String) data.get("data");
		fileCreator.getName(content);
		File file = fileCreator.createFile(content);
		executor.initialize(DIR);
		parseHLVL();
		System.out.println("El resultado es:"+fileCreator.fileReader());
		return fileCreator.fileReader();
	}

	private void parseHLVL() throws InterruptedException, IOException {
		List<String> params = new ArrayList<String>();
		String command = "java -jar " + DIR + "/dependencies/HLVLParserV1.2.jar"  +DIR+ HLVL_DIR + FileManager.DEFAULT_NAME+ ".hlvl";
		System.out.println(command);
		params.add(command);
		executor.setCommandInConsole(params);
		executor.runCmd();
	}
	
}
