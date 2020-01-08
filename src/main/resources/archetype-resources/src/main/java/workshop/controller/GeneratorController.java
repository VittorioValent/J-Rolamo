#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.workshop.controller;

import io.swagger.annotations.Api;
import ${package}.workshop.CodeGenerator;
import ${package}.workshop.utils.ControllerTypeEnum;
import ${package}.workshop.utils.EntityInfo;
import ${package}.workshop.utils.ServiceTypeEnum;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public void generateEntityFlow(@RequestParam String entityName, @RequestParam Boolean auditable, @RequestParam ServiceTypeEnum serivceType, @RequestParam ControllerTypeEnum controllerType) {
        CodeGenerator.generateEntityFlow(new EntityInfo(entityName, new ArrayList<>(), auditable, serivceType, controllerType));
    }

    @PostMapping("/entityflow")
    public void generateEntityFlow(@RequestBody EntityInfo entityInfo) {
        CodeGenerator.generateEntityFlow(entityInfo);
    }
}
