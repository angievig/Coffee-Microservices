package com.coffee.controller;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.coffee.modelParsers.featureIDEToHlvlParser.FeatureIDEToHLVL;
import com.coffee.modelParsers.varXmlToHLVLParser.VariamosXMLToHlvlParser;

@RestController
public class Controller {

	@CrossOrigin
	@RequestMapping(value = "/coffeMP/feature2Hlvl", method = RequestMethod.POST, produces = "text/plain")
	@ResponseBody
	public String executeTest(@RequestBody JSONObject data) throws Exception {
			FeatureIDEToHLVL fParser = new FeatureIDEToHLVL();
		System.out.println(data);
		return fParser.parse((String) data.get("data"));
	}

	@CrossOrigin
	@RequestMapping(value = "/coffeMP/varXML2Hlvl", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String varXML2Hlvl(@RequestBody JSONObject data) throws Exception {
		System.out.println(data);
		VariamosXMLToHlvlParser vParser = new VariamosXMLToHlvlParser();
	
	return vParser.parse((String) data.get("data"));
	}

	@CrossOrigin
	@RequestMapping(value = "/coffeMP/splot2Hlvl", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String splot2Hlvl(@RequestBody String data) {

		return "";
	}
}