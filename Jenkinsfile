pipeline {
     agent any
	 tools {
        maven 'maven3.6' 
	jdk 'jdk1.8'
    }
	 environment {
        containerName = "shraddhal/seleniumtest3"
        container_version = "1.0.0.${BUILD_ID}"
        dockerTag = "${containerName}:${container_version}"
		     
    }
    stages { 	
	    stage('Clone repository') {
			   steps {	       
				 git 'https://github.com/shraddhaL/seleniumrepo3.git' }
        
			   }
	    
	   stage('Build Jar') {
	    
		steps {////
		   	//sh'docker stop $(docker ps -q) || docker rm $(docker ps -a -q) || docker rmi $(docker images -q -f dangling=true)'
        		bat 'docker system prune --all --volumes --force'
		       bat 'mvn clean package  -DskipTests'
        }
        }
	       stage('Build Image') {
            steps {
                script {
                	app = docker.build("shraddhal/seleniumtest3")
                }
            }
        }
	    
	    
       stage('Push Image') {
            steps {
                script {// aws:76599700-71c5-4af4-b805-1bcd97a088e4
			     withCredentials([usernamePassword( credentialsId: 'aecd95e5-cb44-4e0e-93e9-52385789176c', usernameVariable: 'shraddhal', passwordVariable: '')]) {
					
			docker.withRegistry('https://registry.hub.docker.com', 'aecd95e5-cb44-4e0e-93e9-52385789176c') {
					bat "docker login -u shraddhal -p "
					app.push("${BUILD_NUMBER}")
					app.push("latest")
				}
			
             		   }
         	   }
	      }        
   	 }
	    
		
	    stage('compose') {
            steps {
                script {
			bat 'docker volume create --name=search-module-result'
			//sh 'docker run -d -p 4444:4444 --memory="1.5g" --memory-swap="2g" -v /dev/shm:/dev/shm selenium/standalone-chrome'
			bat 'docker-compose up -d'
			bat 'mvn test' 
                }
	    }
        }
	    
	  
}  

}
