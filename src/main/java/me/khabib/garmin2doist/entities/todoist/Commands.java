package me.khabib.garmin2doist.entities.todoist;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Commands {
    private String token;
    private List<Command> commands;
}
