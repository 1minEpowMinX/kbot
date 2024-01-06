pipeline {
	agent any

	parameters {
		choice(name: 'OS', choices: ['linux', 'darwin', 'windows', 'macOS'], description: "Pick OS")
		choice(name: 'ARCH', choices: ['amd64', 'arm64'], description: "Pick ARCH")
	}

	environment {
		REPO = 'https://github.com/1minEpowMinX/kbot'
		BRANCH = 'main'
	}

	stages {

		stage("clone") {
			steps {
				echo 'Clone repository'
				git branch: 'main', credentialsId: 'github', url: 'https://github.com/1minEpowMinX/kbot'
			}
		}

		stage("test") {
			steps {
				echo 'Test exec started'
				sh 'make test'
			}
		}

		stage("build") {
			steps {
				echo 'Build exec started'
				sh 'make build GOOS=${params.OS} GOARCH=${params.ARCH}'
			}
		}

		stage("image") {
			steps {
				echo 'Image build exec started'
				sh 'make image'
			}
		}

		stage("push") {
			steps {
				echo 'Image push exec started'
				script {
					docker.withRegistry('', 'dockerhub') {
						sh 'make push'
					}
				}
			}
		}
	}
}