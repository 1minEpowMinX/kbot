# kbot
The project is a functional bot with further scaling during the learning and practicing period.  
The project also contains custom scripts and yaml-manifests

# YAML PROMPTS

|             NAME            |            PROMPT           |                         DESCRIPTION                       |           EXAMPLE         |
|              -              |              -              |                              -                            |              -            |
| app.yaml                    | create nginx deployment     | YAML to define the basic schema of nginx                  | [app.yaml]                |
| app-livenessProbe.yaml      | create nginx livenessProbe  | YAML to define a liveness probe for nginx                 | [app-livenessProbe.yaml]  |
| app-readinessProbe.yaml     | create nginx readinessProbe | YAML to define a readiness probe for nginx                | [app-readinessProbe.yaml] |
| app-volumeMounts.yaml       | create nginx volumeMounts   | YAML to define and configure storage volumes nginx        | [app-volumeMounts.yaml]   |
| app-cronjob.yaml            | create nginx cronjob        | YAML to define a cron job for nginx                       | [app-cronjob.yaml]        |
| app-job.yaml                |create nginx job             | YAML to define a job for nginx                            | [app-job.yaml]            |
| app-multicontainer.yaml     | create nginx multicontainer | YAML to define a pod that runs more than one container    | [app-multicontainer.yaml] |
| app-resources.yaml          | create nginx resources      | YAML to configure resource requests and limits for nginx  | [app-resources.yaml]      |
| app-secret-env.yaml         | create nginx secret-env     | YAML to define environment variables using secrets        | [app-secret-env.yaml]     |
