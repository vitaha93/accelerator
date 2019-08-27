package com.introlabsystems.accelerator.client.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FetchTask implements Serializable {
    String url;
    String returnQueue;
    String response;
}
