# DB-SCRIPTS

## Overview

This module encapsulates Flyway database scripts.

## Table of Contents
-[Description](#description)
-[Naming Format](#naming-format)
- -[Example](#example)

### Description

The database scripts are contained in src/main/resources, under the db/migration directory.
This module is packaged as a jar file, the module needs to be imported into the module where the 
Flyway scripts are to be executed from, ie app module.

### Naming Format

V{X}.{Y}__{name}.sql

|Value| Description                                                                                                                            |
|-----|----------------------------------------------------------------------------------------------------------------------------------------|
|X| number representing last "major" migration version - this is intended to be incremented per ticket                                     |
|Y| a number representing each individual script required within a ticket - early numbersprovide the base for later scripts |
|name| description name using snake case|

#### Example

V1.2_create_dummy_table.sql

