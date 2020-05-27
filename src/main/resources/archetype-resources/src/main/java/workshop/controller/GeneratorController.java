#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.workshop.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import ${package}.actuator.ApplicationService;
import ${package}.workshop.CodeGenerator;
import ${package}.workshop.domain.EntityInfo;
import ${package}.workshop.domain.FieldInfo;
import ${package}.workshop.repository.EntityInfoRepository;
import ${package}.workshop.repository.FieldInfoRepository;
import ${package}.workshop.utils.ControllerTypeEnum;
import ${package}.workshop.utils.ScriptExecutor;
import ${package}.workshop.utils.ServiceTypeEnum;

/**
 * @author Vittorio Valent
 * @since 1.0
 */
@RestController
@CrossOrigin
@RequestMapping("/workshop")
@Api(value = "Code Generator")
public class GeneratorController {

	@Autowired
	ApplicationService applicationService;

	@Autowired
	EntityInfoRepository entityInfoRepository;

	@Autowired
	FieldInfoRepository fieldInfoRepository;

	@Autowired
	ScriptExecutor scriptExecutor;

	@GetMapping("/entityflow")
	public void generateEntityFlow(@RequestParam String entityName, @RequestParam Boolean auditable,
			@RequestParam ServiceTypeEnum serviceType, @RequestParam ControllerTypeEnum controllerType) {

		EntityInfo entityInfo = EntityInfo.builder()
				.auditable(auditable)
				.controllerType(controllerType)
				.entityName(entityName)
				.serviceType(serviceType)
				.build();
		CodeGenerator
				.generateEntityFlow(entityInfoRepository.save(entityInfo));

		applicationService.restart();
	}

	@PostMapping("/entityflow")
	public void generateEntityFlow(@RequestBody EntityInfo entityInfo) {
//		try {
//			scriptExecutor.createFrontendClasses(entityInfo.getEntityName(), entityInfo.getFields());

//			entityInfo = entityInfoRepository.save(entityInfo);
			CodeGenerator.generateEntityFlow(entityInfo);

//			for (FieldInfo field : entityInfo.getFields()) {
//				field.setEntityInfo(entityInfo);
//				fieldInfoRepository.save(field);
//			}

			applicationService.restart();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
}
