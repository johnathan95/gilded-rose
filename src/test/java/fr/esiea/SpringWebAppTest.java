package fr.esiea;

import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

public class SpringWebAppTest {
    @Test
    public void test_main() {
        String[] args = null;
        SoftAssertions solftly = new SoftAssertions();

        SpringWebApp.main(args);
        solftly.assertThat(SpringWebApp.state).as("main state").isEqualTo(0);
    }
}
