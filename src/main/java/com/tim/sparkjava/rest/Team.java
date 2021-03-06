package com.tim.sparkjava.rest;

import java.util.Objects;

/**
 * Created by tim on 03/07/16.
 */
public class Team {
    private final String teamName;
    private final String managerName;

    public Team(final String teamName, final String managerName) {
        this.teamName = teamName;
        this.managerName = managerName;
    }

    @Override
    public String toString() {
        return String.format("[teamName: %s] [managerName: %s]", teamName, managerName);
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        final Team other = (Team) obj;
        return Objects.equals(this.teamName, other.teamName)
                && Objects.equals(this.managerName, other.managerName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this);
    }
}