package org.deeplearning4j.ui.storage;

import lombok.Getter;
import lombok.Setter;

public class CustomStatsStorage extends InMemoryStatsStorage {
    @Setter
    @Getter
    String accuracy;

}
