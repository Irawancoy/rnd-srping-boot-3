package com.rnd.springboot3;

import com.rnd.springboot3.grpc.CarGrpc;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

import java.io.IOException;

@SpringBootApplication
@ComponentScan(basePackages = {
        "com.rnd.springboot3.service",
        "com.rnd.springboot3.controller",
        "com.rnd.springboot3.repository"
})
public class Springboot3Application {

	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(Springboot3Application.class, args);

		/** Config for gRPC*/
		Server server = ServerBuilder
				.forPort(9090)
				.addService(new CarGrpc()).build();
		server.start();
		server.awaitTermination();
	}

}