### How to run
Run `./mvnw gatling:test -Dgatling.simulationClass=<path to Simulation class>` command
   - ex) `./mvnw gatling:test -Dgatling.simulationClass=simulation.LocalTest`

### MacOC modify maxfiles
- check maxfiles command:
  - ```shell
    $ `launchctl limit maxfiles`
    >  maxfiles    65536          200000```
- modify maxfiles:
  - ```shell
    $ sudo launchctl limit maxfiles 65536 200000
    ```
- maxfiles: setting which limit the number of open files and processes 