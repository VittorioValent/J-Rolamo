package it.pkg.workshop.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import it.pkg.workshop.CodeGenerator;
import it.pkg.workshop.utils.EntityInfo;

/**
 * @author Vittorio Valent
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/workshop")
@Api(value = "Code Generator")
public class GeneratorController {

	@GetMapping("/entityflow")
	public void generateEntityFlow(@RequestParam String entityName, @RequestParam Boolean auditable) {
		CodeGenerator.generateEntityFlow(new EntityInfo(entityName, new ArrayList<>(), auditable));
	}

	@PostMapping("/entityflow")
	public void generateEntityFlow(@RequestBody EntityInfo entityInfo) {
		CodeGenerator.generateEntityFlow(entityInfo);
	}
}
