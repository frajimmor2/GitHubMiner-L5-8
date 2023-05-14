package aiss.lab3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import gitlab.api.model.Project;
import gitlab.api.repository.GithubMinerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Optional;

@EnableJpaRepositories("gitlab.api.repository")
@ComponentScan("gitlab.api")
@SpringBootTest(classes=Project.class)
class GithubMinerApplicationTests {

	@Autowired
	GithubMinerRepository githubService;


	@Test
	void findProject() {
		Project project;
		project = githubService.findProject("JoseGTD", "test", Optional.of(2), Optional.of(20), Optional.of(20));
		Assertions.assertNotNull(project, "The list of commits is empty!!!");
		System.out.println(project);
	}
	@Test
	void postProject(){
		Project project;
		project = githubService.findProject("JoseGTD", "test", Optional.of(2), Optional.of(20), Optional.of(20));
		Assertions.assertNotNull(project, "The list of commits is empty!!!");
		Project res = githubService.postProject(project);
		System.out.println(res);
	}

	}
