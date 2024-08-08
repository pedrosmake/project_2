package org.example.mappers;

import org.example.models.Client;
import org.example.models.ClientResponse;

import java.util.List;
import java.util.stream.Collectors;

public class ClientMapper {
    public static List<ClientResponse>
    mapClientListToClientResponseList(final List<Client> clients) {
        return clients
                .stream()
                .map(client -> new ClientResponse(
                        client.getId(),
                        client.getName(),
                        client.getAddress(),
                        client.getPhone(),
                        client.getCreateDate(),
                        client.getAcquiredBy())
                )
                .collect(Collectors.toList());
    }
}
