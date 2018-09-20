//
//  SECEventJSONParser.swift
//  SEC Challenge
//
//  Created by SEC2018 on 9/19/18.
//  Copyright © 2018 SEC2018. All rights reserved.
//

import Foundation

class SECEventJSONParser: JSONParser {
    
    let dateFormatter = DateFormatter()
    
    func parsed(json: SingleItemJSON) -> [Any]? {
        return parsedEvents(json?[SECEventKeys.events.rawValue])
    }
    
    /**
     Returns array of **SECEvent** items from JSON array
    */
    func parsedEvents(_ rawRecords: ArrayOfDictionariesJSON) -> [SECEvent]? {
        guard let records = rawRecords else { return nil }
        
        return records.compactMap { (rawEvent) -> SECEvent? in
            guard
                let idString = rawEvent[SECEventKeys.id.rawValue] as? String,
                let id = Int(idString),
                
                let typeString = rawEvent[SECEventKeys.type.rawValue] as? String,
                let nameString = rawEvent[SECEventKeys.name.rawValue] as? String,
                let rawSpeakersList = rawEvent[SECEventKeys.speakers.rawValue] as? [[String:String]],
                let dateString = rawEvent[SECEventKeys.date.rawValue] as? String,
                let venueString = rawEvent[SECEventKeys.venue.rawValue] as? String,
                let agendaList = rawEvent[SECEventKeys.agenda.rawValue] as? [[String:String]],
                let descriptionString = rawEvent[SECEventKeys.description.rawValue] as? String
                else {
                    print("Could not parse JSON: \(rawEvent)")
                    return nil }
            
            let eventType = SECEventType(rawValue: typeString) ?? .undefined
            let speakerList = speakers(from: rawSpeakersList)
            let dateOfEvent = date(from: dateString)
            let agendaOfEvent = agenda(from: agendaList)
            
            return SECEvent(id: id,
                            type: eventType,
                            name: nameString,
                            speakers: speakerList,
                            date: dateOfEvent,
                            venue: venueString,
                            agenda: agendaOfEvent,
                            description: descriptionString)
        }
    }
}

extension SECEventJSONParser {
    /**
     Returns array of **SECAgendaItem** from JSON array of dictionaries
     
     - parameter rawAgenda: Array of dictionaries representing agenda item in JSON
     */
    func agenda(from rawAgenda: [[String:String]]) -> [SECAgendaItem] {
        return rawAgenda.compactMap({ (rawAgendaItem) -> SECAgendaItem? in
            guard
                let time = rawAgendaItem[SECEventKeys.time.rawValue],
                let title = rawAgendaItem[SECEventKeys.title.rawValue]
                else { return nil }
            
            return SECAgendaItem(time: time, title: title)
        })
    }
    
    /**
     Returns **Date** of event from JSON string representation
     
     - parameter dateString: String representing agenda item in JSON
     */
    func date(from dateString:String) -> Date? {
        dateFormatter.dateFormat = SECConstants.dateFormat.rawValue
        return dateFormatter.date(from: dateString)
    }
    
    /**
     Returns array of **SECSpeaker** from json array of dictionaries
     
     - parameter dateString: String representing agenda item in JSON
     */
    func speakers(from speakersList: [[String:String]]) -> [SECSpeaker] {
        return speakersList.compactMap({ (rawSpeaker) -> SECSpeaker? in
            guard
                let name = rawSpeaker[SECEventKeys.name.rawValue],
                let position = rawSpeaker[SECEventKeys.position.rawValue]
                else { return nil }
            
            
            let avatarURLString = rawSpeaker[SECEventKeys.avatar.rawValue]
            let avatarURL = URL(string: avatarURLString ?? "")
            
            return SECSpeaker(name: name, position: position, avatarURL: avatarURL)
        })
    }
}
