package com.padwan.test.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.padwan.test.repository.JediStatusRepository;

@Service
public class JediStatusService {

  @Autowired
  private JediStatusRepository jediStatusRepository;

  public String getJedisPorCategoria() {
    String[] jedisPorCategoria = jediStatusRepository.getJedisPorCategoria();

    JSONObject json = new JSONObject();
    List<JSONObject> objects = new ArrayList<>();

    Arrays.asList(jedisPorCategoria).forEach(row -> {
      JSONObject item = new JSONObject();
      String[] values = row.split(",");

      item.put("id", values[0]);
      item.put("status", values[1]);
      item.put("count", values[2]);

      objects.add(item);
    });

    json.accumulate("result", objects);

    return json.toString();
  }

}
