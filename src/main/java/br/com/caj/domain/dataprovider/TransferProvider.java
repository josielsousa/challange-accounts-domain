package br.com.caj.domain.dataprovider;

import java.util.Set;
import br.com.caj.domain.entity.Transfer;

/**
 * TransferProvider - Interface to provide transfers manipulation.
 */
public interface TransferProvider {

  Transfer create(Transfer transfer);

  Set<Transfer> getAllTransfers(String accountUuid);

}
