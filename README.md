# kbot
The project is a functional bot with further scaling during the learning and practicing period.  
The project also contains custom scripts and yaml-manifests  

# Helm chart and realese  
Dear Users,
We are excited to announce the first release of the bot-project! This release marks a significant milestone in our journey to provide multi-arch builds and support for Kubernetes installations.<br>
To make it easier to deploy and manage, we have created a Helm chart that can be used to install and configure the application on Kubernetes clusters. The Helm chart includes all the necessary configurations and dependencies to get you up and running quickly.<br>
In addition to the Helm chart, we have also created a GitHub release that includes the chart package, along with detailed release notes and instructions on how to deploy and use bot-project. This release is available now on our GitHub repository, and we encourage you to check it out.<br>
[Release](https://github.com/1minEpowMinX/kbot/releases/tag/v1.0.7)<br>
To get started, simply download the Helm chart package from the GitHub release page and use it to install the application on your Kubernetes cluster. You can also view the release notes for more information on new features, bug fixes, and other changes included in this release.<br>  
**INSTRUCTION:**
  - To set the Heml chart use: **helm install <CHART_NAME> <CHART_URL from release or local your path>**
  - Create a secret with your token in namespace: **kubectl create secret generic kbot --from-literal=token='YOUR_TOKEN'**
  - Check if the chart is working: **kubectl get pods**
  - Use the release and enjoy!

Thank you for your support and happy deploying!

Best regards!

# YAML PROMPTS
Created with the support of OpenAI technologies

|             NAME            |            PROMPT           |                         DESCRIPTION                       |                           EXAMPLE                       |
|              -              |              -              |                              -                            |                              -                          |
| app.yaml                    | create nginx deployment     | YAML to define the basic schema of nginx                  | [app.yaml](yaml/app.yaml)                               |
| app-livenessProbe.yaml      | create nginx livenessProbe  | YAML to define a liveness probe for nginx                 | [app-livenessProbe.yaml](yaml/app-livenessProbe.yaml)   |
| app-readinessProbe.yaml     | create nginx readinessProbe | YAML to define a readiness probe for nginx                | [app-readinessProbe.yaml](yaml/app-readinessProbe.yaml) |
| app-volumeMounts.yaml       | create nginx volumeMounts   | YAML to define and configure storage volumes nginx        | [app-volumeMounts.yaml](yaml/app-volumeMounts.yaml)     |
| app-cronjob.yaml            | create nginx cronjob        | YAML to define a cron job for nginx                       | [app-cronjob.yaml](yaml/app-cronjob.yaml)               |
| app-job.yaml                |create nginx job             | YAML to define a job for nginx                            | [app-job.yaml](yaml/app-job.yaml)                       |
| app-multicontainer.yaml     | create nginx multicontainer | YAML to define a pod that runs more than one container    | [app-multicontainer.yaml](yaml/app-multicontainer.yaml) |
| app-resources.yaml          | create nginx resources      | YAML to configure resource requests and limits for nginx  | [app-resources.yaml](yaml/app-resources.yaml)           |
| app-secret-env.yaml         | create nginx secret-env     | YAML to define environment variables using secrets        | [app-secret-env.yaml](yaml/app-secret-env.yaml)         |  

# Workflow  
![workflow-1](https://github.com/1minEpowMinX/kbot/assets/129176682/322bc27a-a92b-4db6-a3cc-4d739bba9647)
