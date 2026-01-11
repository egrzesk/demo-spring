package com.example.demo.adapters;

//import com.fasterxml.jackson.databind.JsonNode;
//import org.springframework.stereotype.Component;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.node.ObjectNode;

//@Component
public class TaskMergePatcher {
//    private final ObjectMapper objectMapper;
//
//    public TaskMergePatcher(ObjectMapper objectMapper) {
//        this.objectMapper = objectMapper;
//    }
//
//    /**
//     * Zastosuj JSON Merge Patch (RFC 7396) to bean based on patch.
//     *
//     * @param patchDocument JSON string zgodny z RFC 7396 (application/merge-patch+json)
//     * @param targetBean    obiekt źródłowy (aktualny stan)
//     * @param beanClass     klasa typu wynikowego (zwykle klasa targetBean)
//     * @return nowy obiekt po zastosowaniu patcha
//     */
//    public <T> T apply(String patchDocument, T targetBean, Class<T> beanClass) {
//        try {
//            // Bean -> JsonNode
//            JsonNode target = objectMapper.valueToTree(targetBean);
//            JsonNode patch = objectMapper.readTree(patchDocument);
//
//            JsonNode merged = applyMergePatch(patch, target);
//
//            // JsonNode -> Bean
//            return objectMapper.treeToValue(merged, beanClass);
//        } catch (Exception e) {
//            throw new IllegalArgumentException("Invalid merge patch or mapping failed", e);
//        }
//    }
//
//    /**
//     * Rdzeń algorytmu RFC 7396 na JsonNode.
//     * - Jeśli patch NIE jest obiektem: patch zastępuje target w całości.
//     * - Jeśli patch jest obiektem: wykonaj merge pól:
//     *    * value == null → usuń klucz z target (dla obiektów) lub ustaw null (dla prostych).
//     *    * value jest obiektem → rekurencyjnie merguj.
//     *    * value jest tablicą lub wartością prostą → podmień.
//     */
//    private JsonNode applyMergePatch(JsonNode patch, JsonNode target) {
//        // 1) Patch nie jest obiektem → pełna zamiana
//        if (!patch.isObject()) {
//            // Zgodnie z RFC: tablice i wartości proste zastępują cel
//            return patch;
//        }
//
//        // 2) Patch jest obiektem → mergujemy pola
//        ObjectNode targetObj = target != null && target.isObject()
//                ? (ObjectNode) target.deepCopy()
//                : objectMapper.createObjectNode();
//
//        ObjectNode patchObj = (ObjectNode) patch;
//
//        patchObj.fieldNames().forEachRemaining(field -> {
//            JsonNode patchValue = patchObj.get(field);
//
//            if (patchValue.isNull()) {
//                // null -> usuń klucz (dla obiekty) lub ustaw null (jeśli pole nie istnieje)
//                targetObj.set(field, null); // ustawiamy na null; alternatywnie: targetObj.remove(field)
//                // Uwaga: wybór między 'remove' a 'set null' zależy od Twojej deserializacji DTO:
//                // - Dla DTO często lepsze jest 'set(field, null)' żeby zachować klucz z null
//                // - Jeśli wolisz całkowite usunięcie klucza: użyj targetObj.remove(field)
//            } else {
//                JsonNode targetValue = targetObj.get(field);
//                if (patchValue.isObject() && targetValue != null && targetValue.isObject()) {
//                    // Obiekt w patchu i obiekt w celu → rekurencyjny merge
//                    JsonNode mergedChild = applyMergePatch(patchValue, targetValue);
//                    targetObj.set(field, mergedChild);
//                } else {
//                    // Tablica lub wartość prosta → pełna podmiana
//                    targetObj.set(field, patchValue);
//                }
//            }
//        });
//
//        return targetObj;
//    }

}
