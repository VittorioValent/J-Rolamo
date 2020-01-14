#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.sample.workshop.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import ${package}.sample.actuator.ApplicationService;
import ${package}.sample.workshop.CodeGenerator;
import ${package}.sample.workshop.utils.ControllerTypeEnum;
import ${package}.sample.workshop.utils.EntityInfo;
import ${package}.sample.workshop.utils.ServiceTypeEnum;

/**
 * @author Vittorio Valent
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/workshop")
@Api(value = "Code Generator")
public class GeneratorController {

	@Autowired
	ApplicationService applicationService;

	@GetMapping("/entityflow")
	public void generateEntityFlow(@RequestParam String entityName, @RequestParam Boolean auditable,
			@RequestParam ServiceTypeEnum serivceType, @RequestParam ControllerTypeEnum controllerType) {
		CodeGenerator
				.generateEntityFlow(new EntityInfo(entityName, new ArrayList<>(), auditable, serivceType, controllerType));
		applicationService.restart();
	}

	@PostMapping("/entityflow")
	public void generateEntityFlow(@RequestBody EntityInfo entityInfo) {
		CodeGenerator.generateEntityFlow(entityInfo);
		applicationService.restart();
	}
}
