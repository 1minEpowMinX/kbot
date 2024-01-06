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
				echo 'CLONE REPOSITORY'
				git branch: 'main', credentialsId: 'github', url: 'https://github.com/1minEpowMinX/kbot'
			}
		}

		stage("test") {
			steps {
				echo 'TEST EXEC STARTED'
				sh 'make test'
			}
		}

		stage("build") {
			steps {
				echo 'BUILD EXEC STARTED'
				sh "make build GOOS=${params.OS} GOARCH=${params.ARCH}"
			}
		}

		stage("image") {
			steps {
				echo 'IMAGE BUILD EXEC STARTED'
				sh 'make image'
			}
		}

		stage("push") {
			steps {
				echo 'IMAGE PUSH EXEC STARTED'
				script {
					docker.withRegistry('', 'dockerhub') {
						sh 'make push'
					}
				}
			}
		}
	}
}