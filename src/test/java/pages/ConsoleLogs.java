package pages;

import helpers.Attach;

import static org.assertj.core.api.Assertions.assertThat;

public class ConsoleLogs {

    public ConsoleLogs checkConsoleLogs() {
        String consoleLogs = Attach.getConsoleLogs();
        String errorText = "SEVERE";
        assertThat(consoleLogs).doesNotContain(errorText);

        return this;
    }
}
