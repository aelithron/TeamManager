package com.aelithron.teamManager;

import java.util.List;
import java.util.UUID;

public class Team {
    private final UUID id;
    private String name;
    private List<UUID> members;
    private UUID founder;

    public Team(UUID id, String name, List<UUID> members, UUID founder) {
        this.id = id;
        this.name = name;
        this.founder = founder;
        this.members = members;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public String setName(String name) {
        this.name = name;
        return name;
    }

    public List<UUID> getMembers() {
        return members;
    }
    public UUID addMember(UUID member) {
        members.add(member);
        return member;
    }
    public UUID removeMember(UUID member) {
        members.remove(member);
        return member;
    }

    public UUID getFounder() {
        return founder;
    }
    public UUID setFounder(UUID founder) {
        this.founder = founder;
        return founder;
    }
}
