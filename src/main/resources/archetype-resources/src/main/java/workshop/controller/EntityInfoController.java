#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.workshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ${package}.workshop.domain.FieldInfo;
import ${package}.workshop.repository.EntityInfoRepository;
import ${package}.workshop.repository.FieldInfoRepository;

/**
 * @author Vittorio Valent
 * @since 1.0
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/api/public/entity")
public class EntityInfoController {

	@Autowired
	EntityInfoRepository entityInfoRepository;

	@Autowired
	FieldInfoRepository fieldInfoRepository;

	@GetMapping("/displayedColumns")
	public List<FieldInfo> getDisplayedColumns(@RequestParam String entityName) {
		return fieldInfoRepository
				.findByEntityInfoAndToDisplay(entityInfoRepository.findByEntityName(entityName).get(0), Boolean.TRUE);
	}

	@GetMapping("/displayedFilters")
	public List<FieldInfo> getDisplayedFilters(@RequestParam String entityName) {
		return fieldInfoRepository
				.findByEntityInfoAndToFilter(entityInfoRepository.findByEntityName(entityName).get(0), Boolean.TRUE);
	}
}