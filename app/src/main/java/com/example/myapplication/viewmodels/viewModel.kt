import androidx.collection.emptyObjectLongMap
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

import androidx.lifecycle.viewModelScope
import com.example.myapplication.services.RetrofitClient
import kotlinx.coroutines.launch
import quicktype.SampleDatum

class CounterViewModel : ViewModel() {

    private val _testdata = MutableStateFlow<List<SampleDatum>>(emptyList())
    val testdata: StateFlow<List<SampleDatum>> get() = _testdata

    private val _items = MutableStateFlow<List<SampleDatum>>(emptyList())
    val items: StateFlow<List<SampleDatum>> get() = _items

    private val _filteredItems = MutableStateFlow<List<SampleDatum>>(emptyList())
    val filteredItems: StateFlow<List<SampleDatum>> get() = _filteredItems

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> get() = _loading

    fun fetchItemsFromApi() {
        viewModelScope.launch {
            _loading.value = true
            try {
                val response = RetrofitClient.apiService.fetchItems()
                _items.value = response
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                _loading.value = false
            }
        }
    }

    fun fetchItemsApi(id: String) {
        viewModelScope.launch {
            _loading.value = true
            try {
                val response = RetrofitClient.apiService.fetchItem(id)
                _items.value = listOf(response)
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                _loading.value = false
            }
        }
    }



}
